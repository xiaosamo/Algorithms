package 牛客面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/4/11
 * @description
 */
public class 方格走法 {
    static int X,Y;
    static int ans;
    static boolean [][]vis;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        X= in.nextInt()+1;
        Y = in.nextInt() + 1;
        vis = new boolean[X][Y];

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x == X - 1 && y == Y - 1) {
            ++ans;
//            return;
        }

        if (x + 1 >= 0 && x + 1 < X && y >= 0 && y < Y && !vis[x+1][y]) {
            vis[x+1][y] = true;
            dfs(x + 1, y);
            vis[x+1][y] = false;

        }
        if (x >= 0 && x < X && y + 1 >= 0 && y + 1 < Y && !vis[x][y + 1]) {
            vis[x][y + 1] = true;
            dfs(x, y + 1);
            vis[x][y + 1] = false;

        }
    }


}
