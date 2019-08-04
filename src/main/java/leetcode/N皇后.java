package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/1/14
 */
public class N皇后 {
    // 注意不用加static
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, n);
        return ans;
    }


    private void dfs(char[][] board, int k, int n) {
        if (k >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(board[i]));
            }
            ans.add(list);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (board[k][c] == '.' ) {
                if (isValid(board, k, c, n)) {
                    board[k][c] = 'Q';
                    dfs(board, k + 1, n);
                }
                board[k][c] = '.';
            }

        }

    }

    private boolean isValid(char[][] board, int x, int y, int n) {
        // 验证行、列
        for (int i = 0; i < n; i++) {
            if (board[x][i] == 'Q' || board[i][y] == 'Q') {
                return false;
            }
        }

        // 验证对角
        for (int i = -n; i < n; i++) {
            int nx = i + x;
            int ny = i + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 'Q') {
                    return false;
                }
            }
            nx = x - i;
            ny = y + i;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 'Q') {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        N皇后 obj = new N皇后();
        List<List<String>> lists = obj.solveNQueens(8);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }

    }
}
