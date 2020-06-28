package leetcode.每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/4/15
 */
public class 矩阵 {
    int m,n;

    /**
     * 从每个点开始bfs遍历，超时
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    bfs(i, j, matrix);
                }
            }
        }
        return matrix;
    }

    int[][] dx = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    class Node{
        int x,y,d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    private void bfs(int x, int y, int[][] matrix) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i][0];
                int ny = node.y + dx[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] == 0) {
                    matrix[x][y] = node.d + 1;
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i][0];
                int ny = node.y + dx[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] == 1) {
                    queue.add(new Node(nx, ny, node.d + 1));
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] a =
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1},
                };
        矩阵 obj = new 矩阵();
        int[][] ma = obj.updateMatrix(a);
        for (int[] row : ma) {
            System.out.println(Arrays.toString(row));
        }

    }
}
