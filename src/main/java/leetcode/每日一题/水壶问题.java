package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/21
 */
public class 水壶问题 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a,int b){
        return b == 0 ? a : gcd(b, a % b);
    }




    public static void main(String[] args) {
        水壶问题 obj = new 水壶问题();
        System.out.println(obj.canMeasureWater(3, 5, 4));
    }
}
