package leetcode;

/**
 * @author yuan
 * @date 2020/6/28
 * 双指针
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(new 长度最小的子数组().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new 长度最小的子数组().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
