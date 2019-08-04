package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class WaitSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        // wait
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread A get lock");
                    try {
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        // 一直等待，知道调用notify或notifyAll唤醒
                        lock.wait();
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        // 使第一个线程先执行
        Thread.sleep(10);

        // sleep
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10ms");
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                        // 唤醒
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
