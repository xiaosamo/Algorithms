package leetcode.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/29
 */
public class 地图分析 {
    int[][] dx = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    class  Node{
        int x,y,dis;

        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, bfs(i, j, grid, m, n));
                }
            }
        }
        return ans;
    }

    private int bfs(int x, int y, int[][] grid, int m, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        boolean[][] vis = new boolean[m][n];
        vis[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i][0];
                int ny = node.y + dx[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                    if (grid[nx][ny] == 1) {
//                        System.out.println(nx + " " + ny);
                        return node.dis + 1;
                    }
//                    int dis = getDist(nx, ny, x, y);
                    queue.offer(new Node(nx, ny, node.dis + 1));
                    vis[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    private int getDist(int x0, int y0, int x1, int y1) {
        return Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }

    public static void main(String[] args) {
        地图分析 obj = new 地图分析();
        int[][] a = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] b = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(obj.maxDistance(a));
        System.out.println( new 地图分析().maxDistance(b));

    }
}
