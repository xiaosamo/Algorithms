package 校赛;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/17
 * @description
 */
public class 魔法石 {
    static int[][] d = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int time = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int n = in.nextInt();
            time = 0;
            String[] g = new String[n];
            String[] tg = new String[n];
            boolean[][] vis = new boolean[n][n];
//            g[0] = "...";
//            g[1] = "#..";
//            g[2] = "...";

            for (int i = 0; i < n; i++) {
                g[i] = in.next();
                tg[i] = g[i];
            }

//            System.out.println(isok(g, n));

//            for (int i = 0; i < n; i++) {
//                System.out.println(g[i]);
//            }
            int ans = Integer.MAX_VALUE;


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i].charAt(j) == '#') {
                        vis[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i].charAt(j) == '.') {

                        String str = new String(g[i].substring(0, j) + "#" + g[i].substring(j + 1));
                        g[i] = str;

                        int t = dfs2(g, n, i, j, vis, 0);
                        if (isok(g, n)) {
                            ans = Math.min(ans, t);
                        }

//                         str = new String(g[i].substring(0, j) + "." + g[i].substring(j + 1));
//                        g[i] = str;

                        resetG(tg, g);

//                        g = tg;
//                        time = 0;
//
//                        dfs(g, n, i, j, vis);
//                        System.out.println(time);
//                        ans = Math.min(ans, time);
//                        boolean flag = false;
//                        for (int k = 0; k < d.length; k++) {
//                            int nx = i + d[k][0];
//                            int ny = j + d[k][1];
//                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx].charAt(ny) == '#') {
//                                flag = true;
//                                break;
//                            }
//                        }
//                        if (!flag) {
//                            dfs(g, n, i, j);
//                        }
                    }
                }
            }
            System.out.println(ans);

//            System.out.println(isok(g, n));
        }

    }

    private static void resetG(String[] tg, String[] g) {
        for (int i = 0; i < g.length; i++) {
            g[i] = tg[i];
        }
    }

    public static int dfs2(String[] g, int n, int x, int y, boolean[][] vis, int time) {
        if (isok(g, n)) {
            return time;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + d[k][0];
            int ny = y + d[k][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx].charAt(ny) == '.' && !vis[nx][ny]) {
                vis[nx][ny] = true;
                String t = new String(g[nx].substring(0, ny) + "#" + g[nx].substring(ny + 1));
                g[x] = t;

                int res = dfs2(g, n, nx, ny, vis, time + 1);
                if (isok(g, n)) {
                    return res;
                }

                vis[nx][ny] = false;
                t = new String(g[nx].substring(0, ny) + "." + g[nx].substring(ny + 1));
                g[x] = t;

            }
        }
        return Integer.MAX_VALUE;
//        return time;
    }

    private static void dfs(String[] g, int n, int x, int y,boolean [][]vis) {
        if (isok(g, n)) {
            return;
        }
        // change . to #


//        sb.replace(y, y, "#");
//        g[x] = sb.toString();

//        char[] chars = g[x].toCharArray();
//        chars[y] = '#';
//        g[x] = String.valueOf(chars[y]);


        // 补全#
//        repair(g, n);

//        String t = new String(g[x].substring(0, y) + "#" + g[x].substring(y + 1));
//        g[x] = t;
        for (int k = 0; k < 4; k++) {
            int nx = x + d[k][0];
            int ny = y + d[k][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx].charAt(ny) == '.' && !vis[nx][ny]) {
                if (!judge(g, n, nx, ny)) {
                    vis[nx][ny] = true;
                    String t = new String(g[nx].substring(0, ny) + "#" + g[nx].substring(ny + 1));
                    g[x] = t;
                    ++time;

                    dfs(g, n, nx, ny, vis);

                    vis[nx][ny] = false;
                    t = new String(g[nx].substring(0, ny) + "." + g[nx].substring(ny + 1));
                    g[x] = t;
                    --time;
                }


            }
        }

//        g[x].charAt(y) = '#';

    }

    private static void repair(String[] g, int n) {
//        if (!judge(g, n, x, y)) {
//            for (int k = 0; k < 4; k++) {
//                int nx = x + d[k][0];
//                int ny = y + d[k][1];
//
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i].charAt(j) == '.') {

//                    dfs(g, n, i, j,);
                }


//                if (g[i].charAt(j) == '.') {
////                    if (!judge(g, n, i, j)) {
////                        for (int k = 0; k < 4; k++) {
////                            int nx = i + d[k][0];
////                            int ny = j + d[k][1];
////                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx].charAt(ny) == '.' && !judge(g, n, i, j)) {
////                                String t = new String(g[nx].substring(0, ny) + "#" + g[nx].substring(ny + 1));
////                                g[nx] = t;
////                                ++time;
////                            }
////                        }
//////                        dfs(g, n, i, j);
////                    }
////                }
            }
        }
    }

    /**
     * 判断x，y的四个方向是否ok
     * @param g
     * @param n
     * @param x
     * @param y
     * @return
     */
    private static boolean judge(String[] g, int n, int x, int y) {
        int t = 0;
        for (int k = 0; k < d.length; k++) {
            int nx = x + d[k][0];
            int ny = y + d[k][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx].charAt(ny) == '#') {
                ++t;
            }
        }
        return t % 2 == 0;
    }

    private static boolean isok(String[] g, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i].charAt(j) == '.') {
                    if (!judge(g, n, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
