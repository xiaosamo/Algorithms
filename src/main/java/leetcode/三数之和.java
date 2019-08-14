package leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int t = -(nums[i] + nums[j]);
                int result = Arrays.binarySearch(nums, t);
                if (result > 0 && result != i && result != j) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], t);
                    Collections.sort(list);
                    if (!ans.contains(list)) {
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 双指针
     * 需要处理重复的数字
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            // 去掉重复的起点
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) ++l;
                    while (l < r && nums[r] == nums[r - 1]) --r;
                    --r;
                    ++l;
                } else if (sum > 0) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return result;
    }

        public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum2(nums);
    }
}
