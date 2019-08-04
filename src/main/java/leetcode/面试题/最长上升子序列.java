package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/8
 * @description
 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        最长上升子序列 obj = new 最长上升子序列();
        System.out.println(obj.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(obj.lengthOfLIS(new int[]{1,2,3,4,5}));
        System.out.println(obj.lengthOfLIS(new int[]{5,4,3,2,1}));
        System.out.println(obj.lengthOfLIS(new int[]{5,4,3,5}));
    }
}
