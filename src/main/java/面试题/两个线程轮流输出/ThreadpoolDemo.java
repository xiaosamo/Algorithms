package 面试题.两个线程轮流输出;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 */
public class ThreadpoolDemo {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A:1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B:1");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C:1");
            }
        });


        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);

    }
}
