package leetcode;

/**
 * @author yuan
 * @date 2020/1/26
 * 直接遍历数组，只要前面有相邻的方格，就-2
 */
public class 岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res+=4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }

                }
            }
        }
        return res;
    }


}
