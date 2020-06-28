package 并发编程.读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuan
 * @date 2020/6/27
 */
public class CachedData {
    Object data;
    volatile boolean cacheValid;

    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // 如果缓存失效，获取写锁
            // 获取写锁之前，必须先释放读锁
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // 这里需要再次判断数据的有效性,因为在我们释放读锁和获取写锁的空隙之内，可能有其他线程修改了数据
                if (!cacheValid) {
                    data = new Object();
                    cacheValid = true;
                }
                // 在不释放写锁的情况下，直接获取读锁，这就是读写锁的降级
                rwl.readLock().lock();
            }finally {
                // 释放了写锁，但是依然持有读锁
                rwl.writeLock().unlock();
            }
        }
        try {
            System.out.println(Thread.currentThread().getName() + ", data:" +data);
        }finally {
            // 释放读锁
            rwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        CachedData cachedData = new CachedData();
        new Thread(() -> cachedData.processCachedData()).start();
        new Thread(() -> cachedData.processCachedData()).start();
        new Thread(() -> cachedData.processCachedData()).start();
        new Thread(() -> cachedData.processCachedData()).start();

    }
}
