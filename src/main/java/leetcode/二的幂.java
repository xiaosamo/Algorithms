package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class 二的幂 {
    public static boolean isPowerOfTwo(int n) {
        double d = 1;
        BigDecimal b = new BigDecimal(Integer.toString(n));
        for (int i = 0; ; i++) {
            d = Math.pow(2.0, i);
            BigDecimal a = new BigDecimal(Double.toString(d));
//            System.out.println("a=" + a.toPlainString());
            if (a.compareTo(b) == 0) {
                return true;
            } else if (a.compareTo(b) > 0) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(2147483647));
    }
}
