package 并发编程.atomicref;

import utils.T;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuan
 * @date 2020/6/27
 * 实现一个可重入的自旋锁
 * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=267
 */
public class ReentrantSpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    // 重入次数
    private  int count = 0;

    public void lock(){
        Thread t = Thread.currentThread();
        if (t == owner.get()) {
            ++count;
            return;
        }

        // 自旋获取锁
        while (!owner.compareAndSet(null, t)) {
            // 原来值null，尝试设置为t
//            System.out.println("自旋了");
        }
    }

    public void unlock(){
        Thread t = Thread.currentThread();
        if (t == owner.get()) {
            if (count > 0) {
                --count;
            } else {
                // 此处无需CAS操作，因为没有竞争，因为只有线程持有者才能解锁
                owner.set(null); // 重新设置为null
            }
        }
    }

    public static void main(String[] args) {
        ReentrantSpinLock spinLock = new ReentrantSpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");

            spinLock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "获取了自旋锁");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
                spinLock.unlock();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
