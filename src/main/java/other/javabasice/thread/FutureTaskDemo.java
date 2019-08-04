package other.javabasice.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            //  任务还没执行完
            System.out.println("task has not finished,please wait...");
        }
        System.out.println("tast return :" + task.get());
    }
}
