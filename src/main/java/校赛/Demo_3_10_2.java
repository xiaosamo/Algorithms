package 校赛;

import java.util.Arrays;
        import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/10
 * @description 千军万马过独木桥
 */
public class Demo_3_10_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int k = 0; k < T; k++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(solve(a, n));
        }

    }

    private static long solve(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        if (n == 2) {
            return Math.max(a[0], a[1]);
        }

        Arrays.sort(a);
        long sum = 0L;
        for (int i = n - 1; i > 0; i--) {
            sum = sum + a[i];
        }
        return sum;
    }
}
