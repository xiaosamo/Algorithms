package 并发编程;

import java.util.concurrent.locks.StampedLock;

/**
 * @author yuan
 * @date 2020/2/13
 * ReadWriteLock 支持两种模式：一种是读锁，一种是写锁。而 StampedLock 支持三种模式，分别是：写锁、悲观读锁和乐观读。其中，写锁、悲观读锁的语义和 ReadWriteLock 的写锁、读锁的语义非常类似，允许多个线程同时获取悲观读锁，但是只允许一个线程获取写锁，写锁和悲观读锁是互斥的。不同的是：StampedLock 里的写锁和悲观读锁加锁成功之后，都会返回一个 stamp；然后解锁的时候，需要传入这个 stamp。
 *
 * StampedLock 的性能之所以比 ReadWriteLock 还要好，其关键是 StampedLock 支持乐观读的方式。ReadWriteLock 支持多个线程同时读，但是当多个线程同时读的时候，所有的写操作会被阻塞；而 StampedLock 提供的乐观读，是允许一个线程获取写锁的，也就是说不是所有的写操作都被阻塞。
 */
public class StampedLockTest {
    final StampedLock sl = new StampedLock();

    private int x, y;


    // 计算到原点的距离
    private int distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();

        // 读入局部变量，
        // 读的过程数据可能被修改
        int curX = x,curY = y;

        // 判断执行读操作期间，
        // 是否存在写操作，如果存在，则 sl.validate 返回 false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();

            try {
                curX= x;
                curY = y;

            }finally {
                // 释放悲观读锁
                sl.unlockRead(stamp);

            }
        }
        return (int) Math.sqrt(curX * curX + curY + curY);
    }



}
