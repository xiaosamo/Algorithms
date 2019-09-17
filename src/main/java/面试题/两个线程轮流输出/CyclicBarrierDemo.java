package 面试题.两个线程轮流输出;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * 计数达到指定值时释放所有等待线程
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier barrier1 = new CyclicBarrier(2);
    private static CyclicBarrier barrier2 = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A:1"); //放开栅栏1
                    barrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier1.await();
                    System.out.println("B:1");
                    barrier2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier2.await();
                    System.out.println("C:1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });


        t3.start();
        t2.start();
        t1.start();

    }
}
