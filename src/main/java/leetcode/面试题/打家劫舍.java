package leetcode.面试题;


/**
 * @author yuan
 * @date 2019/3/8
 * @description
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // 抢与不抢
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1};
        打家劫舍 obj = new 打家劫舍();
        System.out.println(obj.rob(a));
    }
}
