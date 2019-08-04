package other.javabasice.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2019/4/2
 * @description
 */
public class LockTest {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
//        Lock lock = new ReentrantLock();
//        try {
//            // 加锁
//            lock.lock();
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//
//            }
//        }finally {
//            // 释放锁
//            lock.unlock();
//        }

    }
}
