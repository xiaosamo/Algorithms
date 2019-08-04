package 蓝桥杯;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 用筛法求之N内的素数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        boolean[] vis = new boolean[n + 1];
        for (int i = 2; i <= m; i++) {
            if (!vis[i]) {
                for (int j = i * i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                System.out.println(i);
            }
        }
    }
}
