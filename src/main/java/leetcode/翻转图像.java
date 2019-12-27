package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/12/18
 * @description
 */
public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int []a:A) {
            flipHorizontal(a);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    private void flipHorizontal(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            swap(a, i, n - i - 1);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        翻转图像 obj = new 翻转图像();
//        int[] a = {1, 1, 0, 0};
        int[] a = {1, 1, 0};
        obj.flipHorizontal(a);

        System.out.println(Arrays.toString(a));
    }
}
