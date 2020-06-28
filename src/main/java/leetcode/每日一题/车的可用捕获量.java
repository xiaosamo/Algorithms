package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/26
 */
public class 车的可用捕获量 {
    public int numRookCaptures(char[][] board) {
        int m=board.length,n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    return find(i, j, m, n, board);
                }
            }
        }
        return 0;
    }

    private int find(int x, int y, int m, int n, char[][] board) {
        int sum = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                sum+=1;
                break;
            }
        }
        for (int i = x + 1; i < n; i++) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                sum += 1;
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                sum+=1;
                break;
            }
        }

        for (int i = y + 1; i <m; i++) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                sum+=1;
                break;
            }
        }

        return sum;
    }
}
