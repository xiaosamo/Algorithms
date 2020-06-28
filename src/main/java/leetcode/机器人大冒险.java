package leetcode;

/**
 * @author yuan
 * @date 2020/1/8
 * @description
 */
public class 机器人大冒险 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
       return dfs(command, 0, obstacles, 0, 0, x, y);
    }

    private boolean dfs(String command, int index, int[][] obstacles, int x, int y, int ex, int ey) {

        if (x == ex && y == ey) {
            return true;
        }

        if (x >= ex && y >= ey) {
            return false;
        }

        if (index == command.length()) {
            return dfs(command, 0, obstacles, x, y, ex, ey);
        }



        for (int[] o : obstacles) {
            if (o[0] == x && o[1] == y) {
                return false;
            }
        }
        System.out.println("x=" + x + ",y=" + y);


        char c = command.charAt(index);
        if (c == 'U') {
           return dfs(command, index + 1, obstacles, x , y+1, ex, ey);
        } else {
            return dfs(command, index + 1, obstacles, x+1, y , ex, ey);
        }
    }

    public static void main(String[] args) {
        机器人大冒险 obj = new 机器人大冒险();
        System.out.println(obj.robot("URR", new int[][]{}, 3, 2));
    }
}
