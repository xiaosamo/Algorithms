package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/6/13
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int a = 1,b=1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a=b;
            b=ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯().climbStairs(2));
        System.out.println(new 爬楼梯().climbStairs(3));
    }

}
