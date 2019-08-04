package poj;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 棋盘问题 {
    static int N,K;
    static int ans;
    static char[][] g;
    static int[][] d = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            K = in.nextInt();
            if (N == -1 && K == -1) {
                return;
            }
            ans = 0;
             g = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = in.next();
                g[i] = s.toCharArray();
            }

            boolean[]vis = new boolean[N];
            dfs(0, 0, vis);
            System.out.println(ans);
        }

    }

    private static void dfs(int x, int k, boolean[] vis) {

        if (k == K) {
            ++ans;
            return;
        }
        if (x == N) {
            return;
        }

        // 当前行不放的情况

        // 当前行放的情况
        for (int i = 0; i < N; i++) {
            if (g[x][i] == '#' && !vis[i]) {
                vis[i] = true;
                dfs(x + 1, k + 1, vis);
                vis[i] = false;
            }
        }
        dfs(x + 1, k, vis);

    }
}
