package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/20
 */
public class 岛屿数量 {
    int m,n;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ++ans;
                }
            }
        }
        return ans;
    }

    int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                dfs(nx, ny, grid);
            }
        }
    }
}
