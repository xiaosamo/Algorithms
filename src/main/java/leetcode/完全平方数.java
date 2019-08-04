package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/1/15
 */
public class 完全平方数 {
    /**
     * dp[n] = min{dp[n], dp[n - i*i ] + 1}
     * @param n
     * @return
      */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 填充
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        完全平方数 obj = new 完全平方数();
        System.out.println(obj.numSquares(12));
    }
}
