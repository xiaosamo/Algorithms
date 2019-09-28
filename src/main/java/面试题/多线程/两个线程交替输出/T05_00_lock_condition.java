package 面试题.多线程.两个线程交替输出;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2019/9/28
 * @description
 * 也是好的写法
 */
public class T05_00_lock_condition {
    /**
     * sync只有一种状态
     * 而ReentrantLock可以用一把锁，做出两个条件，这种条件下锁定第一个线程，那种条件下锁定第二个线程
     */
    static Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition(); // 让线程1执行
    static Condition condition2 = lock.newCondition(); // 让线程2执行

    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();

            try {
                for (int i = 1; i <= 26; i++) {
                    System.out.print(i);
                    condition2.signal(); // 唤醒第二个线程
                    condition1.await();  // 线程1等待
                }

                condition2.signal(); // 必须
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }).start();

        new Thread(() -> {
            lock.lock();

            try {
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.print(c);
                    condition1.signal(); // 唤醒线程1
                    condition2.await(); // 线程2等待
                }

                condition1.signal(); // 必须
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
