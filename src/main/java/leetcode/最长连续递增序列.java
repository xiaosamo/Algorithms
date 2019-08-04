package leetcode;

/**
 * @author yuan
 * @date 2019/1/17
 */
public class 最长连续递增序列 {
    /**
     * dp(i) =
     * 1.a[i] > a[i-1] : dp(i-1) + 1
     * 2.dp(i) = 1
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        最长连续递增序列 obj = new 最长连续递增序列();
        System.out.println(obj.findLengthOfLCIS(a));


    }
}
