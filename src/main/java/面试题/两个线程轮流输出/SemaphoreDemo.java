package 面试题.两个线程轮流输出;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * 线程1先获取许可，然后给s2一个许可，再给s3
 */
public class SemaphoreDemo {

    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);
    private static Semaphore s3 = new Semaphore(0);


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s1.acquire(); // 当前线程尝试去阻塞的获取1个许可证,此过程是阻塞的,当前线程获取了1个可用的许可证，则会停止等待，继续执行
                    System.out.println("A:1");
                    s2.release(); // 当前线程释放1个可用的许可证。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s2.acquire();
                    System.out.println("B:1");
                    s3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s3.acquire();
                    System.out.println("C:1");
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        t3.start();
        t2.start();
        t1.start();

    }
}
