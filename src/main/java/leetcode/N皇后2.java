package leetcode;

/**
 * @author yuan
 * @date 2019/11/25
 * @description
 */
public class N皇后2 {
    int count = 0;
    public int totalNQueens(int n) {
        dfs(n,0,new int[n]);
        return count;
    }

    private void dfs(int n, int row, int[] columns) {
        if (row == n) {
            ++count;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(row, col, columns)) {
                // 如果当前列合法，继续放下一个
                columns[row] = col;
                dfs(n, row + 1, columns);
                columns[row] = -1; // 回溯
            }
        }
    }

    private boolean check(int row,int col,int []columns){
        for (int r = 0; r < row; r++) {
            // 判断是否有列冲突或对角线冲突
            if (columns[r] == col || row - r == Math.abs(columns[r] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N皇后2 obj = new N皇后2();
        System.out.println(obj.totalNQueens(4));

    }
}
