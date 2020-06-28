package 并发编程.读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuan
 * @date 2020/6/27
 */
public class Demo {
    final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
//        upgrade();
        downgrade();
    }

    /**
     * 锁降级
     */
    private static void downgrade() {
        rwl.writeLock().lock();
        System.out.println("获取到写锁");
        rwl.readLock().lock();
        System.out.println("获取到读锁");
        System.out.println("成功降级");
    }


    /**
     * 读锁不能升级为写锁
     */
    private static void upgrade() {
        rwl.readLock().lock();
        System.out.println("获取到读锁");
        rwl.writeLock().lock();
        System.out.println("获取到写锁");
        System.out.println("成功升级");
    }


}
