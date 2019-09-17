package 面试题.两个线程轮流输出;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 */
public class CountDownLatchDemo {


    /**
     * 用于判断线程一是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c1 = new CountDownLatch(1);

    /**
     * 用于判断线程二是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A:1");
                c1.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c1.await();
                    System.out.println("B:1");
                    c2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c2.await();
                    System.out.println("C:1");
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
