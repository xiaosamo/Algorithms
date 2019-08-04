package 蓝桥杯.模拟;

import java.math.BigInteger;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class 阶乘位数 {
    private static String f(long n) {
        BigInteger b = BigInteger.ONE;
        for (long i = 1; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        return b.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            String s = f(i);
            if (s.length() >= 10000) {
                System.out.println(i);
                System.out.println(s);
                break;
            }
        }
    }
}
