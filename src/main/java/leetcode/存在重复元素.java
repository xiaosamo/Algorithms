package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 存在重复元素 {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(containsDuplicate(a));

    }
}
