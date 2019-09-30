package 面试题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/30
 * @description
 */
public class 爬楼梯2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger[] dp = new BigInteger[n + 1];

        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        dp[3] = new BigInteger("2");
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 3]);
        }
        System.out.println(dp[n]);

    }
}
