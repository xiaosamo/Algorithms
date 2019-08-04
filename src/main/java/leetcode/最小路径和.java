package leetcode;

/**
 * @author yuan
 * @date 2019/1/15
 */
public class 最小路径和 {
    /**
     * dp(m,n) = min{dp(m-1,n),dp(m,n-1)} + grid[m][n]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1 && j >= 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i >= 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j >= 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        最小路径和 obj = new 最小路径和();
        System.out.println(obj.minPathSum(a));
    }
}
