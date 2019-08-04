package other.javabasice.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan
 * @date 2019/4/3
 * @description
 */
public class ThTest {


    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 15; i++) {
            Task task = new Task(i);
            poolExecutor.execute(task);
            System.out.println("线程池中线程数目：" + poolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" + poolExecutor.getQueue().size() + "，已执行玩别的任务数目：" + poolExecutor.getCompletedTaskCount());
        }



    }
    static class Task implements Runnable{

        private int num;
        public Task(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println("正在执行task: " + num + ", 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + num + " 执行完毕");

        }
    }
}
