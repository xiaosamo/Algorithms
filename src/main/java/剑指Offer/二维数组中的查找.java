package 剑指Offer;

/**
 * @author yuan
 * @date 2019/6/1
 * @description
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int r = 0;
        int row = array.length;
        int col = array[0].length - 1;

        while (r < row && col >= 0) {
            if (array[r][col] == target) {
                return true;
            } else if (array[r][col] > target) {
                // 剔除列
                --col;
            } else {
                // 剔除行
                ++r;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        二维数组中的查找 obj = new 二维数组中的查找();
        int[][] a = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(obj.Find(7,a));
        System.out.println(obj.Find(5,a));
    }
}
