package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class 方格走法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();


        /**
         * 注意只能走格点，你画个网格就知道了。
         * 所以 3 * 2 的网格，实际上格点数却是 4 * 3 。
         */
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[x][y]);
    }
}
