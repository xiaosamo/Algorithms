package hdu;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/13
 * @description
 */
public class 最短路_2544 {

    private static int max = 10005;
    /**
     * 边
     */
    private static List<Edge>[] G = new List[max];

    private static class Edge {
        /**
         * 边的一个点
         */
        int e;

        /**
         * 边的权值
         */
        int w;
        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    /**
     * 从起点s到e终点的最短距离
     * @param start
     * @param end
     * @return
     */
    private static int spfa(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[max];
        int[] dist = new int[max];

        // 将距离初始化为无穷大
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 起点入队列
        queue.offer(start);
        dist[start] = 0;
        vis[start] = true;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (int i = 0; i < G[v].size(); i++) {
                int e = G[v].get(i).e;
                int w = G[v].get(i).w;
                if (dist[e] > dist[v] + w) {
                    dist[e] = dist[v] + w;
                    if (!vis[e]) {
                        vis[e] = true;
                        queue.offer(e);
                    }
                }
            }
            // 记得恢复
            vis[v] = false;
        }
        return dist[end];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // n个顶点、m条边
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                return;
            }
            for (int i = 0; i < G.length; i++) {
                G[i] = new LinkedList<>();
            }


            for (int i = 0; i < m; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();
                G[s].add(new Edge(e, w));
                G[e].add(new Edge(s, w));
            }

            System.out.println(spfa(1, n));
        }
    }
}
