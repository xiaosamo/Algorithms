package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/2
 */
public class 生命游戏 {
    int[] dx = {0, -1, 1};
    int[][] copyBoard;
    int m,n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        copyBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, board);
            }
        }

    }

    private void dfs(int x, int y,int[][] board) {
        int liveNeighbors = 0;  // 查看相邻的细胞是否是活细胞
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int nx = x + dx[i];
                int ny = y + dx[j];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && copyBoard[nx][ny] == 1) {
                    liveNeighbors++;
                }
            }
        }

        // 规则 1 或规则 3
        if ((copyBoard[x][y] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
            board[x][y] = 0;
        }
        // 规则 4
        if (copyBoard[x][y] == 0 && liveNeighbors == 3) {
            board[x][y] = 1;
        }

    }
}
