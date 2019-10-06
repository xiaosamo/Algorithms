package 面试题.深信服;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/6
 * @description
 */
public class 集合遍历 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = in.nextInt();
        }

        dfs(a);
    }

    private static void dfs(int[] a) {

    }
}
