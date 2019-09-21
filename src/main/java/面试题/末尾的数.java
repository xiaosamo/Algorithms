package 面试题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/19
 * @description
 */
public class 末尾的数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));

    }

    private static int solve(int n) {
        BigInteger num = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }
        char []chars = num.toString().toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                return chars[i] - '0';
            }
        }
        return 0;
    }
}
