package 面试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class 有序矩阵中第K小的元素 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();

        int[] a = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[k - 1]);
    }
}
