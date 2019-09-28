package 面试题.端御信息;

/**
 * @author yuan
 * @date 2019/6/1
 * @description
 */
public class Main2 {
    public static boolean find(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int r = 0;
        int row = matrix.length;
        int col = matrix[0].length - 1;

        while (r < row && col >= 0) {
            if (matrix[r][col] == target) {
                return true;
            } else if (matrix[r][col] > target) {
                // 删除列
                --col;
            } else {
                // 删除行
                ++r;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {5, 7, 8, 10, 15},
                {6, 8, 10, 11, 17},
        };

        System.out.println(find(matrix, 14) ? 'Y' : 'N');
        System.out.println(find(matrix, 10) ? 'Y' : 'N');
    }
}
