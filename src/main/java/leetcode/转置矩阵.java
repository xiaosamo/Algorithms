package leetcode;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 转置矩阵 {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }


}
