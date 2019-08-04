package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class 反转整数 {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;

            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
//        BigDecimal big = new BigDecimal(Math.pow(2, 31) - 1);
//        System.out.println(big.toPlainString());
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

    }
}
