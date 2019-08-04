package other.javabasice.thread;

import java.util.concurrent.Callable;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "testValue";
        System.out.println("Read to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
