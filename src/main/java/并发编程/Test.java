package 并发编程;

/**
 * @author yuan
 * @date 2020/1/27
 * 缓存导致的可见性问题
 * 直觉告诉我们应该是 20000，因为在单线程里调用两次 add10K() 方法，count 的值就是 20000，但实际上 calc() 的执行结果是个 10000 到 20000 之间的随机数。为什么呢？
 *
 * 我们假设线程 A 和线程 B 同时开始执行，那么第一次都会将 count=0 读到各自的 CPU 缓存里，执行完 count+=1 之后，各自 CPU 缓存里的值都是 1，同时写入内存后，我们会发现内存中是 1，而不是我们期望的 2。之后由于各自的 CPU 缓存里都有了 count 的值，两个线程都是基于 CPU 缓存里的 count 值来计算，所以导致最终 count 的值都是小于 20000 的。这就是缓存的可见性问题。
 */
public class Test {

    private static int count = 0;

    private static void add10K(){
        for (int i = 0; i < 10000; i++) {
            /**
             * count += 1，至少需要三条 CPU 指令。
             *
             * 指令 1：首先，需要把变量 count 从内存加载到 CPU 的寄存器；
             * 指令 2：之后，在寄存器中执行 +1 操作；
             * 指令 3：最后，将结果写入内存（缓存机制导致可能写入的是 CPU 缓存而不是内存）。
             */
            count+=1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            add10K();
        });

        Thread t2 = new Thread(() -> {
            add10K();
        });

        // 启动两个线程
        t1.start();
        t2.start();

        // 等待两个线程执行结束
        t1.join();
        t2.join();

        System.out.println(count);


    }

}
