package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/16
 * @description
 */
public class 连续子数组的最大和 {
    /**
     * dp(i) 表示以i结尾的子数组的最大和
     * dp(i) = max(dp(i-1) + a[i] , a[i])
     * dp(0) = a[0]
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }

        int max = -1;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        连续子数组的最大和 obj = new 连续子数组的最大和();
        System.out.println(obj.FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
    }
}
