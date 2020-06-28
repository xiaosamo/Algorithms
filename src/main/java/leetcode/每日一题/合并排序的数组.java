package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/3
 * 从尾部开始填充
 */
public class 合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (i < 0) {
                A[k--] = B[j--];
            } else if (j < 0) {
                A[k--] = A[i--];
            } else if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
    }

    public static void main(String[] args) {
        合并排序的数组 obj = new 合并排序的数组();
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        obj.merge(A, 3, B, 3);

        System.out.println(Arrays.toString(A));
    }
}
