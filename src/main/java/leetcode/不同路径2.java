package leetcode;

/**
 * @author yuanshijia
 * @date 2019-08-07
 * @description
 * https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode/
 */
public class 不同路径2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            // 遍历第一行，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 dp[i,j] = dp[i,j-1]。
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            // 遍历第一列，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 dp[i,j] = dp[i-1,j]。
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        不同路径2 obj = new 不同路径2();
        int[][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] b = {
                {1, 0}
        };
        System.out.println(obj.uniquePathsWithObstacles(a));// 2
        System.out.println(obj.uniquePathsWithObstacles(b));// 0
    }
}
