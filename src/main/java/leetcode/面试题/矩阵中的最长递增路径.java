package leetcode.面试题;


/**
 * @author yuan
 * @date 2019/3/7
 * @description dp + dfs
 * 其中dp[i][j]表示数组中以(i,j)为起点的最长递增路径的长度，初始将dp数组都赋为0
 * 当我们用递归调用时，遇到某个位置(x, y), 如果dp[x][y]不为0的话，我们直接返回dp[x][y]即可，不需要重复计算。
 */
public class 矩阵中的最长递增路径 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] dp) {
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] > matrix[x][y]) {
                max = Math.max(max, dfs(matrix, nx, ny, dp) + 1);
            }
        }
        dp[x][y] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] a = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int[][] b = {
                {1, 2},
                {2, 3}
        };
        int[][] c =
                {
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}
                };
        矩阵中的最长递增路径 obj = new 矩阵中的最长递增路径();
//        System.out.println(obj.longestIncreasingPath(a)); // 4
        System.out.println(obj.longestIncreasingPath(c)); // 4
//        System.out.println(obj.longestIncreasingPath(b)); //2


    }
}
