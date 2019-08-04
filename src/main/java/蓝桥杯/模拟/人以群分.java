package 蓝桥杯.模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 人以群分 {
    static int[] a;
    static int n,m;
    static int []dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        a = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a, 1, n + 1);

        int l = 0, r = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isok(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    private static boolean isok(int x) {
        for (int i = m; i <= n; i++) {
            if (a[i] - a[dp[i - m] + 1] <= x) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n] == n;
    }
}
