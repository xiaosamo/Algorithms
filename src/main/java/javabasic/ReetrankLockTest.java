package javabasic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2019/4/24
 * @description
 */
public class ReetrankLockTest {
    private static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRunnable(i)).start();
        }
    }

    static class MyRunnable implements Runnable {
        private Integer id;

        public MyRunnable(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁线程的id：" + id);
                lock.unlock();
            }
//            String.class.getDeclaredMethod()
        }
    }
}
