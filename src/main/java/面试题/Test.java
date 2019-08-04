package 面试题;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yhf
 * @date 2019/5/9
 * @description
 */
public class Test {
    public static void main(String[] args) {
//        ArrayList obj = new ArrayList();
//        obj.add("A");
//        obj.ensureCapacity(3);
//        System.out.println(obj.size());

        Random random = new Random();
        System.out.println(random.nextDouble());


//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(()->{
            System.out.println(random.nextDouble());
        });

        executorService.execute(()->{
            System.out.println(random.nextDouble());
        });

        executorService.execute(()->{
            System.out.println(random.nextDouble());
        });

        System.out.println(ThreadLocalRandom.current().nextDouble());
        System.out.println(ThreadLocalRandom.current().nextDouble());
        System.out.println(ThreadLocalRandom.current().nextDouble());
    }
}
