package 面试题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/19
 * @description
 */
public class 永远不可能到达的地方 {
    static int s,e,m,n;

    static boolean[] flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        int[][] g = new int[n + 1][n + 1];

        flag = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x][y] = g[y][x] = 1;
        }
        s = in.nextInt();
        e = in.nextInt();

        flag[s] = true;
//        dfs(g, s);
        bfs(g);

//        for (int i = 0; i < flag.length; i++) {
//            if (!flag[i]) {
//                System.out.println(i);
//            }
//        }
    }

    private static void bfs(int[][] g) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == e) {
                flag[e] = true;
                for (int i = 1; i < n; i++) {
                    if (!flag[i]) {
                        System.out.print(i + " ");

                    }
                }
                if (!flag[n]) {
                    System.out.print(n);
                }
//                System.out.println(Arrays.toString(flag));
                return;
            }

            flag[cur] = true;
            for (int i = 1; i <= n; i++) {
                if (g[cur][i] == 1) {
                    q.offer(i);
                }
            }

        }


    }


        private static void dfs(int[][] g,int cur) {
        if (cur == e) {

            for (int i = 2; i < n; i++) {
                if (!flag[i]) {
                    System.out.print(i + " ");

                }
            }
            if (!flag[n]) {
                System.out.print(n);
            }

//            System.out.println(Arrays.toString(flag));
//            System.out.println("ok");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (g[cur][i] == 1 && !flag[i]) {
                flag[i] = true;
                dfs(g, i);
                flag[i] = false;
            }
        }
    }


}
