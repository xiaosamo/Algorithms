package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/1/17
 */
public class 最长上升子序列 {
    /**
     * dp(i)表示以i结尾的最长上升子序列
     * 当aj<ai(j<i)且dp(j)+1>dp(i)时，dp(i)=dp(j)+1。
     * 外层i枚举每个数，内层j枚举目前i的最优值，即O（n^2）
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        int max = -1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * O(nlgn)
     *  dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     *  由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     *  对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     *  1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     *     数组尾部, 并将最长递增序列长度maxL加1
     *  2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     * @param nums
     */
    public int lengthOfLIS2(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int l = 0, r = maxL;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (num > dp[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[l] = num;
            if (l == maxL) {
                ++maxL;
            }
        }
        return maxL;
    }


        public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = {0};
        最长上升子序列 obj = new 最长上升子序列();
        System.out.println(obj.lengthOfLIS(a));
        System.out.println(obj.lengthOfLIS(b));
        System.out.println(obj.lengthOfLIS2(a));
        System.out.println(obj.lengthOfLIS2(b));

    }
}
