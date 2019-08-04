package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/8/4
 * @description
 */
public class Shopee的办公_dp {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();

        int[][] g = new int[x + 1][y + 1];
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < n; i++) {
//            x = in.nextInt();
//            y = in.nextInt();
            g[in.nextInt()][in.nextInt()] = 1;
        }
        dp[0][1] = 1;
        dp[1][0] = 1;


//        dfs(g, 0, 0, vis);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 1 && i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else if (g[i][j] == 0 && i - 1 >= 0 && j - 1 >= 0) {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
//                System.out.print(g[i][j] + " ");
            }
//            System.out.println();
        }


//        for (int i = 0; i < g.length; i++) {
//            for (int j = 0; j < g[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(ans);
        System.out.println(dp[x][y]);
    }

    private static void dfs(int[][] g, int x, int y, int[][] vis) {

        if (x + 1 == g.length && y + 1 == g[0].length) {
            ++ans;
            return;
        }
//        System.out.println("x=" + x + ",y=" + y);

        // 上
        if (x + 1 < g.length && vis[x + 1][y] == 0 && g[x + 1][y] == 0) {
            vis[x + 1][y] = 1;
            dfs(g, x + 1, y, vis);
            vis[x + 1][y] = 0;
        }
        if (y + 1 < g[0].length && vis[x][y + 1] == 0 && g[x][y + 1] == 0) {
            vis[x][y + 1] = 1;
            dfs(g, x, y + 1, vis);
            vis[x][y + 1] = 0;
        }

    }
}
