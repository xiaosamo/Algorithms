package 并发编程;

/**
 * @author yuan
 * @date 2020/1/27
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    private void writer(){
        x=42;
        v = true;
    }

    private void reader(){
        if (v) {
            // 这里 x 会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread a = new Thread(() -> {
            example.writer();

        });

        Thread b = new Thread(() -> {
            example.reader();

        });

        a.start();
        b.start();


        /**
         * 分析一下，为什么 1.5 以前的版本会出现 x = 0 的情况呢？我相信你一定想到了，变量 x 可能被 CPU 缓存而导致可见性问题。这个问题在 1.5 版本已经被圆满解决了。Java 内存模型在 1.5 版本对 volatile 语义进行了增强。怎么增强的呢？答案是一项 Happens-Before 规则。
         */

    }
}
