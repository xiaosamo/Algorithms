package leetcode;

/**
 * @author yuan
 * @date 2019/1/15
 */
public class 爬楼梯 {
    /**
     * 执行用时: 10856 ms, 在Climbing Stairs的Java提交中击败了0.96% 的用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 执行用时: 3 ms, 在Climbing Stairs的Java提交中击败了79.59% 的用户
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] f = new int[n+3];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }


    public static void main(String[] args) {
        爬楼梯 obj = new 爬楼梯();
        System.out.println(obj.climbStairs(3));
        System.out.println(obj.climbStairs(4));
        System.out.println(obj.climbStairs2(3));
        System.out.println(obj.climbStairs2(4));
    }
}
