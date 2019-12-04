package leetcode;

/**
 * @author yuan
 * @date 2019/12/2
 * @description
 */
public class 最长上升子序列_ {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 注意最小为1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }

}
