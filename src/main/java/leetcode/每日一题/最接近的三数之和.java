package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/6/24
 * 和三数之和类似
 * 排序 + 双指针
 */
public class 最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int num = nums[0];
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    ++l;
                } else if (sum > target) {
                    --r;
                } else {
                    // sum == target
                    return target;
                }
                int t = Math.abs(target - sum);
                if (t < ans) {
                    ans = t;
                    num = sum;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new 最接近的三数之和().threeSumClosest(nums, 1));
        System.out.println(new 最接近的三数之和().threeSumClosest(new int[]{0, 1, 2}, 3));
        System.out.println(new 最接近的三数之和().threeSumClosest(new int[]{0, 1, 2}, 0));

    }
}
