package leetcode.每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/4/15
 * 不错的题！bfs
 * 多源 BFS
 */
public class 矩阵2 {
    int[][] dx = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    /**
     * 换个思路，把所有0的位置入队列，然后开始bfs
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i][0];
                int ny = node.y + dx[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                    matrix[nx][ny] = node.d + 1;
                    queue.add(new Node(nx, ny, node.d + 1));
                    vis[nx][ny] = true;
                }
            }
        }
        return matrix;
    }
    class Node{
        int x,y,d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) {
        int[][] a =
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1},
                };
        矩阵2 obj = new 矩阵2();
        int[][] ma = obj.updateMatrix(a);
        for (int[] row : ma) {
            System.out.println(Arrays.toString(row));
        }

    }
}