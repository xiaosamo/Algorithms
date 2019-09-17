package 面试题.两个线程轮流输出;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 */
public class JoinMainDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A:1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B:1");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C:1");
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();

    }
}
