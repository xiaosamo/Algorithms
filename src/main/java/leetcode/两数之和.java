package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {0, 0};
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;

                }
            }
        }


        return ans;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{i, map.get(t)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));



    }
}

