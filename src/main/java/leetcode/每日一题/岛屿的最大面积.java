package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/15
 */
public class 岛屿的最大面积 {
    int[][] dx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(dfs(i, j, m, n, grid, 1), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int x, int y, int m, int n, int [][]grid,int cur) {

        int sum = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                sum += dfs(nx, ny, m, n, grid, cur + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        岛屿的最大面积 obj = new 岛屿的最大面积();
        int[][] g = {
                {1, 1, 1}
        };
        System.out.println(obj.maxAreaOfIsland(g));
    }
}
