package hdu;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/13
 * @description
 */
public class 最短路_2544_floyd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // n个顶点、m条边
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                return;
            }

            int[][] d = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 防止溢出
                    d[i][j] = Integer.MAX_VALUE >> 1;
                }
            }

            for (int i = 0; i < m; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();

                d[s][e] = d[e][s] = w;
            }


            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
            System.out.println(d[1][n]);
        }
    }
}
