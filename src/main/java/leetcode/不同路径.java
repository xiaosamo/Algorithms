package leetcode;

/**
 * @author yuanshijia
 * @date 2019-08-07
 * @description
 * 经典dp
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    // 如果是边界，左边界或上边界，只有一条路径
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        不同路径 obj = new 不同路径();
        System.out.println(obj.uniquePaths(3, 2));   // 3
        System.out.println(obj.uniquePaths(7, 3));   // 28
        System.out.println(obj.uniquePaths(1, 3));   // 1
    }
}
