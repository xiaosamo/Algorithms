package leetcode.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/29
 * 多源BFS
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
 */
public class 地图分析2 {
    int[][] dd = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    class  Node{
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        boolean hasOcean = false;
        Node node = null;
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dd[i][0];
                int ny = node.y + dd[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                    grid[nx][ny] = grid[node.x][node.y] + 1;
                    hasOcean = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        if (node == null || !hasOcean) {
            return -1;
        }
        return grid[node.x][node.y] - 1;
    }

    public static void main(String[] args) {
        地图分析2 obj = new 地图分析2();
        int[][] a = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] b = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(obj.maxDistance(a));
        System.out.println( new 地图分析2().maxDistance(b));

    }
}
