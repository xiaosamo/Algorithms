package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 模数求和 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i] - 1;
        }
        System.out.println(sum);
    }
}
