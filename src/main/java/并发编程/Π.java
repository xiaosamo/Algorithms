package 并发编程;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @author yuan
 * @date 2020/2/16
 */
public class Π {

    private static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                // 开启并行
//                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();

    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();

        pi(10000000);


        System.out.println((System.currentTimeMillis() -s)/1000 + " s");


    }
}
