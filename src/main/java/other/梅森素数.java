package other;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * @author yuan
 * @date 2020/2/15
 * effective java p176
 *
 * 2^p - 1 (p是素数)
 *
 */
public class 梅森素数 {
    /**
     * 从2开始，返回无限stream
     * @return
     */
    private static Stream<BigInteger> primes(){
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }


    /**
     * intValueExact 将BigInteger转化为int，检查丢失的信息。
     *
     * boolean isProbablePrime(int certainty)
     * 如果这个BigInteger是素数返回true，如果合数返回false，正确率为1-1/2certainty。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE)) // 2^p - 1
                .filter(mersenne -> mersenne.isProbablePrime(50)) // 过滤不是素数的数字
                .limit(20)
                .forEach(System.out::println);

    }
}
