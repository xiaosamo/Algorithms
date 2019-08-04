package leetcode;

/**
 * @author yuan
 * @date 2019/1/21
 */
public class 单词搜索 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    if (dfs(board, i, j, 1, vis, word)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int cur, boolean[][] vis, String word) {

        if (cur == word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !vis[nx][ny]) {
                if (board[nx][ny] == word.charAt(cur)) {
                    vis[nx][ny] = true;
                    if (dfs(board, nx, ny, cur + 1, vis, word)) {
                        return true;
                    }
                    vis[nx][ny] = false;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        单词搜索 obj = new 单词搜索();
        System.out.println(obj.exist(board, "ABCCED"));
        System.out.println(obj.exist(board, "SEE"));
        System.out.println(obj.exist(board, "ABCB"));
    }
}
