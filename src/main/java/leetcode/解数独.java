package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/1/13
 */
public class 解数独 {
    char[][] ans = new char[9][9];
    public  void solveSudoku(char[][] board) {
        dfs(board, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ans[i][j];
            }
        }
        //        print(ans);
    }



    private  void dfs(char[][] board, int n) {
        if (n >= 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    ans[i][j] = board[i][j];
                }
            }
            return;
        }

        int x = n / 9;
        int y = n % 9;

        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[x][y] = (char) ('0' + i);
                if (isValid(board, x, y)) {
                    dfs(board, n + 1);
                }
                board[x][y] = '.';

            }
        } else {
            dfs(board, n + 1);
        }

    }


    /**
     * 判断(x,y)坐标是否合法
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    public  boolean isValid(char[][] board, int x, int y) {
        // 验证行
        for (int i = 0; i < 9; i++) {
            if (y != i && board[x][y] == board[x][i]) {
                return false;
            }
        }
        // 验证列
        for (int i = 0; i < 9; i++) {
            if (x != i && board[x][y] == board[i][y]) {
                return false;
            }
        }
        // 验证9宫格
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private  void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        解数独 obj = new 解数独();

        obj.solveSudoku(board);

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");;
//
//            }
//            System.out.println();
//        }
//        System.out.println();

        String t = "haha";
        obj.f(t);
        System.out.println(t);

    }

    private void f(String s) {
        System.out.println("s = " + s);
        s = "hello";
        System.out.println("s = " + s);

    }
}
