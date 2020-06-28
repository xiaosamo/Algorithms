package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/8
 */
public class 机器人的运动范围 {
    int[][] dx = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    int ans = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        dfs(0, 0, m, n, k,vis);
        return ans;
    }

    private void dfs(int x, int y, int m, int n, int k, boolean[][] vis) {
        ++ans;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i][0] + x;
            int ny = dx[i][1] + y;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && isOk(nx, ny, k)) {
                vis[nx][ny] = true;
                dfs(nx, ny, m, n, k, vis);
            }
        }
    }

    private boolean isOk(int x, int y, int k) {
        String s = x + "" + y;
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        System.out.println(new 机器人的运动范围().movingCount(2, 3, 1));
        System.out.println(new 机器人的运动范围().movingCount(3, 1, 0));
        System.out.println(new 机器人的运动范围().movingCount(3, 2, 17));
    }
}
