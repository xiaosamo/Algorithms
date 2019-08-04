package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/1/16
 */
public class 最大子序和 {

    /**
     * 因为dp[i]要求是必须以A[i]结尾的连续序列，那么只有两种情况：
     * 1.这个最大和的连续序列只有一个元素，以A[i]开始，A[i]结尾
     * 2.这个最大和的连续序列多个元素，从前面A[p]开始（p<i),一直到A[i]结束。
     * 对于第一种情况，最大和就是A[i]本身。 第二种，最大和是dp[i-1]+A[i]。
     * 于是得到方程：dp[i]=max(dp[i-1]+A[i],A[i])。 边界dp[0]=0.
     * 于是从小到大输出dp数组，找到他的最大值，即为最大子序列和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] a = {-2, 1, -3, 4};

        最大子序和 obj = new 最大子序和();
        System.out.println(obj.maxSubArray(a));

    }
}
