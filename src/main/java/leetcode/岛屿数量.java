package leetcode;

/**
 * @author yuanshijia
 * @date 2019-08-05
 * @description
 */
public class 岛屿数量 {
    int[][] dx = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    int m, n;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int ans = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] g, int x, int y) {
        g[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            if (nx >= 0 && nx < this.m && ny >= 0 && ny < this.n && g[nx][ny] == '1') {
                dfs(g, nx, ny);
            }
        }
    }

}
