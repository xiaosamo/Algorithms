package 并发编程.生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2020/6/22
 */
public class MyBlockingQueueForCondition<T> {
    private Queue<T> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueForCondition(int max) {
        this.max = max;
        queue = new LinkedList<>();
    }

    public void put(T data) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == max) {
                notFull.await();
            }
            queue.offer(data);
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            T data = queue.poll();
            notFull.signalAll();
            return data;
        }finally {
            lock.unlock();
        }
    }
}
