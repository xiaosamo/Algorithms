package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/12/19
 * @description
 */
public class 接雨水2 {
    static class Node{
        int row;
        int col;
        int height; // 高度

        Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] vis = new boolean[m][n];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.height, o2.height));

        // 将四个边的方块加入队列
        for (int i = 0; i < m; i++) {
            vis[i][0] = vis[i][n-1] = true;
            pq.offer(new Node(i, 0, heightMap[i][0]));
            pq.offer(new Node(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            if (!vis[0][i]) {
                pq.offer(new Node(0, i, heightMap[0][i]));
                vis[0][i] = true;
            }
            if (!vis[m-1][i]) {
                pq.offer(new Node(m - 1, i, heightMap[m - 1][i]));
                vis[m - 1][i] = true;
            }
        }


        int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int total = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.row + d[i][0];
                int ny = node.col + d[i][1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    total += Math.max(0, node.height - heightMap[nx][ny]);
                    pq.offer(new Node(nx, ny, Math.max(node.height, heightMap[nx][ny])));
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] h = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        接雨水2 obj = new 接雨水2();

        System.out.println(obj.trapRainWater(h));

    }
}
