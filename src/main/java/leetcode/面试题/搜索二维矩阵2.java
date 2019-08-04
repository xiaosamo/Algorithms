package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/5
 * @description
 */
public class 搜索二维矩阵2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int c = col - 1;

        boolean result = false;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                result = true;
                break;

            } else if (matrix[r][c] > target) {
                --c;
            } else {
                ++r;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        搜索二维矩阵2 obj = new 搜索二维矩阵2();
        int[][] a = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(obj.searchMatrix(a, 5));
        System.out.println(obj.searchMatrix(a, 20));
        System.out.println(obj.searchMatrix(a, 10));
        System.out.println(obj.searchMatrix(new int[][]{}, 1));
        System.out.println(obj.searchMatrix(new int[][]{{-5}}, -5));
        System.out.println(obj.searchMatrix(new int[][]{{-1,3}}, -1));
        System.out.println(obj.searchMatrix(new int[][]{{1,1}}, 0));


    }
}
