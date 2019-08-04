package 剑指Offer;

/**
 * @author yuan
 * @date 2019/1/31
 * @description
 */
public class 矩阵中的路径 {
    int[][] dx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] vis = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, rows, cols, matrix, str, vis, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int rows, int cols, char[] matrix, char[] str, boolean[] vis, int k) {
        int index = x * cols + y;
        if (x < 0 || y < 0 || x >= rows || y >= cols || matrix[index] != str[k] || vis[index]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        vis[index] = true;
        for (int i = 0; i < 4; i++) {
            if (dfs(x + dx[i][0], y + dx[i][1], rows, cols, matrix, str, vis, k + 1)) {
                return true;
            }
        }
        vis[index] = false;
        return false;
    }

    public static void main(String[] args) {
        矩阵中的路径 obj = new 矩阵中的路径();
        System.out.println(obj.hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCB".toCharArray()));
        System.out.println(obj.hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCE".toCharArray()));
        System.out.println(obj.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEMS".toCharArray()));
        System.out.println(obj.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray())); // true

    }
}
