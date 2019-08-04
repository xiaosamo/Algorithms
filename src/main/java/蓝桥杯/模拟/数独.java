package 蓝桥杯.模拟;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class 数独 {
    static int[][] g = {
            {0,2,6,0,0,0,0,0,0},
            {0,0,0,5,0,2,0,0,4},
            {0,0,0,1,0,0,0,0,7},
            {0,3,0,0,2,0,1,8,0},
            {0,0,0,3,0,9,0,0,0},
            {0,5,4,0,1,0,0,7,0},
            {5,0,0,0,0,1,0,0,0},
            {6,0,0,9,0,7,0,0,0},
            {0,0,0,0,0,0,7,5,0},

    };

    private static void dfs(int index) {
        if (index == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(g[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        int x = index / 9;

        int y = index % 9;

        // 如果当前位置有数字
        if (g[x][y] != 0) {
            dfs(index + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (g[x][y] == 0 && isok(x, y, i)) {
                g[x][y] = i;
                dfs(index + 1);
                g[x][y] = 0;
            }
        }


    }

    private static boolean isok(int x, int y, int k) {
        // 循环行和列
        for (int i = 0; i < 9; i++) {
            if (g[x][i] == k || g[i][y] == k) {
                return false;
            }
        }
        // 判断9宫格
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (g[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        dfs(0);
    }
}
