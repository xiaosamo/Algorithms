package leetcode.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/4
 * https://leetcode-cn.com/problems/rotting-oranges/solution/fen-xi-si-lu-bfs-by-peter_pan/
 *
 * 先找出腐烂的橘子，添加进 queue 中。
 * 队列 queue 只让腐烂的橘子入队；
 * 出队时，让当前腐烂橘子四周的新鲜橘子都变为腐烂，即 grid[newX][newY] = 2。
 * 用 minute 记录腐烂的持续时间，每一层的橘子在内一层的橘子的腐烂时间基础之上自增 1，代表时间过了 1 分钟。
 * 最后检查网格中是否还有新鲜的橘子：
 * 有，返回 -1 代表 impossible。
 * 没有则返回 minute。
 *
 */
public class 腐烂的橘子 {
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Node{
        int x,y,minute;
        Node(int x, int y, int minute) {
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        int maxMinute = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxMinute = Math.max(node.minute, maxMinute);
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dir[k][0];
                int ny = node.y + dir[k][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    queue.add(new Node(nx, ny, node.minute + 1));
                }
            }
        }
        // 检查是否还有橘子未腐烂
        for (int[] row : grid) {
            for (int i : row) {
                if (i == 1) {
                    return -1;
                }
            }
        }
        return maxMinute;
    }



    public static void main(String[] args) {
        腐烂的橘子 obj1 = new 腐烂的橘子();
        腐烂的橘子 obj2 = new 腐烂的橘子();
        腐烂的橘子 obj3 = new 腐烂的橘子();
        腐烂的橘子 obj4 = new 腐烂的橘子();
        腐烂的橘子 obj5 = new 腐烂的橘子();
        int[][] g1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] g2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] g3 = {{0,2}};
        int[][] g4 = {{0,2,2}};
        int[][] g5 = {{1,2,2}};

        System.out.println(obj1.orangesRotting(g1)); // 4
        System.out.println(obj2.orangesRotting(g2)); //-1
        System.out.println(obj3.orangesRotting(g3));// 0
        System.out.println(obj4.orangesRotting(g4));// 0
        System.out.println(obj5.orangesRotting(g5));// 1
    }

}
