package leetcode;

/**
 * @author yuan
 * @date 2019/1/13
 */
public class 有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        // 记录行
        boolean[][] row = new boolean[9][10];
        // 记录列
        boolean[][] col = new boolean[9][10];
        // 记录3x3
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    // (i,j)所在的9宫格所对应的行
                    int t = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[t][num]) {

                        return false;
                    } else {
                        row[i][num] = col[j][num] = block[t][num] = true;

                    }
                }

            }
        }
        return true;
    }



}
