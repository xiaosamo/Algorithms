package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2019/4/7
 * @description
 */
public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= 0 || l == 3) {
            // 全是大于等于0的数
            return nums[l - 1] * nums[l - 2] * nums[l - 3];
        }
        // 有负数，且l>3
        return Math.max(nums[l - 1] * nums[l - 2] * nums[l - 3], nums[0] * nums[1] * nums[l - 1]);
    }

    public static void main(String[] args) {
        三个数的最大乘积 obj = new 三个数的最大乘积();
        System.out.println(obj.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(obj.maximumProduct(new int[]{1, 2, 3, 4}));
    }
}
