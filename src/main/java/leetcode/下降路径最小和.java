package leetcode;

/**
 * @author yuan
 * @date 2019/1/16
 */
public class 下降路径最小和 {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0 && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + A[i][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                }

            }
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        下降路径最小和 obj = new 下降路径最小和();
        int[][] a =
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(obj.minFallingPathSum(a));
    }
}
