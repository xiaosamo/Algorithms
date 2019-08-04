package other.javabasice.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2019/4/2
 * @description
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//            }
//        }


        Lock lock = new ReentrantLock();
        lock.lock();
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        lock.unlock();
    }
}
