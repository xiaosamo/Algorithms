package 校赛;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class 跳一跳 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        boolean[] vis = new boolean[n + 1];
        int s = 1;
        int t = 0;
        for (int i = 1; i <= n; i++) {
            s = s + t;
            if (s > n) {
                s %= n;
            }
            ++t;
            vis[s] = true;
        }
        boolean ok = true;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
