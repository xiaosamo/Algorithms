package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/21
 * err
 */
public class 水壶问题2 {
    public boolean canMeasureWater(int x, int y, int z) {
        return dfs(0, 0, x, y, z);
    }
    private boolean dfs(int curX, int curY, int x, int y, int z) {
        if (curX == z || curY == z || curX + curY == z) {
            return true;
        }
        if (curY == 0 || curY == 0) {
            return curX + curY == z || z == 0;
        }

        System.out.println(curX + "," + curY);

        return dfs(x, curY, x, y, z) ||
                dfs(curX, y, x, y, z) ||
                dfs(0, curX + curY, x, y, z) ||
                dfs(curX + curY, 0, x, y, z) ||
                dfs(0, curY, x, y, z) ||
                dfs(curX, 0, x, y, z)
                ;

    }

    public static void main(String[] args) {
        水壶问题2 obj = new 水壶问题2();
        System.out.println(obj.canMeasureWater(3, 5, 4));
    }
}
