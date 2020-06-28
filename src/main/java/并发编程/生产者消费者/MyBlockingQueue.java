package 并发编程.生产者消费者;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2020/6/22
 */
public class MyBlockingQueue<T> {
    private Queue<T> queue;
    private int max = 16;

    public MyBlockingQueue(int max) {
        this.max = max;
        queue = new LinkedList<>();
    }

    public synchronized void put(T data) throws InterruptedException {
        while (queue.size() == max) {
            wait();
        }
        queue.offer(data);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T data = queue.poll();
        notifyAll();
        return data;
    }
}
