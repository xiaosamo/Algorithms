package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 乘积最大子序列 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i] * dp[i - 1];
                } else {
//                    dp[i] = dp[i - 1];
//                    dp[i] = Math.max(nums[i], dp[i - 1]);
                    dp[i] = nums[i];
                }
            } else if (nums[i] > 0) {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = nums[i] * dp[i - 1];
                }
            } else {
                if (dp[i - 1] <= 0) {
                    dp[i] = 0;
                } else {
//                    dp[i] = dp[i - 1];
//                    dp[i] = Math.max(nums[i], dp[i - 1]);
                    dp[i] = 0;

                }
            }
        }
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        乘积最大子序列 obj = new 乘积最大子序列();
        int[] a = new int[]{2, 3, -2, 4};
//        System.out.println(obj.maxProduct(a)); // 6
//        System.out.println(obj.maxProduct(new int[]{-2, 0, -1})); //0
//        System.out.println(obj.maxProduct(new int[]{3, 0, 2,8,-1})); //16
        System.out.println(obj.maxProduct(new int[]{-2, 3 , -4})); //24
    }
}
