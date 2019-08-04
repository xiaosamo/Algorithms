package 蓝桥杯.模拟;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class 找质数 {
    static boolean[] vis = new boolean[1000001];
    public static void main(String[] args) {
        prime(vis.length);
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        for (int i = 2; i < n; i++) {
            if (!vis[i] && !vis[n - i]) {
                System.out.println(i + " " + (n - i));
                return;
            }
        }
    }

    /**
     * 筛选小于n的质数
     *
     * @param n
     */
    private static void prime(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        for (int i = 2; i <= m; i++) {
            if (!vis[i]) {
                for (int j = i * i; j < n; j += i) {
                    vis[j] = true;
                }
            }
        }
    }
}
