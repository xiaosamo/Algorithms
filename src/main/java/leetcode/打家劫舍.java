package leetcode;

import java.util.Arrays;

/**
 * https://www.jianshu.com/p/77f1e8157277
 * @author yuan
 * @date 2019/1/25
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] sums = new int[n];
        Arrays.fill(sums, -1);

        return solve(nums, n - 1, sums);
    }


    private int solve(int[] nums, int index, int[] sums) {
        if (index < 0) {
            return 0;
        }
        if (sums[index] >= 0) {
            return sums[index];
        }

        // 对应不选和选的情况
        sums[index] = Math.max(solve(nums, index - 1, sums), solve(nums, index - 2, sums) + nums[index]);
        return sums[index];
    }



    public int rob2(int[] nums) {
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
        打家劫舍 obj = new 打家劫舍();
        int[] a = {1, 2, 3, 1};
        System.out.println(obj.rob(a));
    }


}
