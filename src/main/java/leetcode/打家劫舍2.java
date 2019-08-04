package leetcode;

/**
 * @author yuan
 * @date 2019/3/8
 * @description
 * 第一个房屋和最后一个房屋是紧挨着的，说明第一个房屋和最后一个房屋不能同时盗取。我们可以考虑两种情况：
 * （1）考虑偷取[0, n - 1]的房屋。
 * （2）考虑偷取[1, n]的房屋。
 */
public class 打家劫舍2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        // 第一次，选择0~n-1
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        int max = dp[n - 2];
        // 第二次，选择1~n
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        max = Math.max(max, dp[n - 1]);
        return max;
    }


    public static void main(String[] args) {

        打家劫舍2 obj = new 打家劫舍2();
        System.out.println(obj.rob(new int[]{2, 3, 2}));
        System.out.println(obj.rob(new int[]{1, 2, 3, 1}));
    }
}
