package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/4/7
 */
public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        // 再对每一行以中点进行翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = t;
            }
        }




    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        旋转矩阵 obj = new 旋转矩阵();
        obj.rotate(a);
        for (int[] r : a) {
            System.out.println(Arrays.toString(r));

        }



    }
}
