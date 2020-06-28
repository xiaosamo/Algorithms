package 并发编程.生产者消费者;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author yuan
 * @date 2020/6/22
 * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=243
 */
public class Demo1 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    String data = UUID.randomUUID().toString();
                    queue.put(data);
                    Thread.sleep(1000);
                    System.out.println("【生产者】生产一条数据:data=" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    String data = queue.take();
                    Thread.sleep(1000);
                    System.out.println("【消费者】消费一条数据:data=" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
