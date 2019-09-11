package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/10
 * @description
 */
public class 硬币划分 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

//        int[] coins = {1, 2, 5, 10};
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] += dp[i - 1];
            if (i - 2 > 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 5 > 0) {
                dp[i] += dp[i - 5];
            }
            if (i - 10 > 0) {
                dp[i] += dp[i - 10];
            }
            dp[i] = dp[i] % 1000000007;
        }
        System.out.println(dp[n]);
    }
}
