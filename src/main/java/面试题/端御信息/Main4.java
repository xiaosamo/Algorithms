package 面试题.端御信息;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 最大重量
        int maxW = in.nextInt();
        // w重量，v费用
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[][] dp = new int[n + 1][maxW + 1];

        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        //当有1件物品，体积为1时有1种情况
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxW; j++) {
                if (j - w[i] >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][maxW]);
    }
}
