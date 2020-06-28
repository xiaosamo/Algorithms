package 并发编程;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuan
 * @date 2020/2/12
 */
public class ThreadRandomTest {
    public static void main(String[] args) {


        int n =10000000;

        int l = 1000;
        Random random = new Random();

        long s = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            random.nextInt(l);
        }
        long e = System.currentTimeMillis();
        System.out.println("Random:" +(e - s) + "ms");

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
         s = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            threadLocalRandom.nextInt(l);
        }
        e = System.currentTimeMillis();
        System.out.println("ThreadLocalRandom:" + (e - s) + "ms");

    }
}
