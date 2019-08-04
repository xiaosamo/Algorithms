package leetcode;

import java.util.*;

public class 求众数2 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length / 3;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
//            System.out.println("left=" + binearyLeft(nums, nums[i]) + ", right= " + binearyRight(nums, nums[i]));
            if (binearyRight(nums, nums[i]) - binearyLeft(nums, nums[i]) > n) {
                result.add(nums[i]);
            }
        }
        if (binearyRight(nums, nums[nums.length - 1]) - binearyLeft(nums, nums[nums.length - 1]) > n) {
            result.add(nums[nums.length - 1]);
        }

        return result;
    }

    private static int binearyLeft(int[] a, int k) {
        int l = 0, r = a.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= k) {
                r = m;
            } else {
                l = m + 1;

            }
        }
        return l;
    }

    private static int binearyRight(int[] a, int k) {
        int l = 0, r = a.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] <= k) {
                l = m + 1;
            } else {
                r = m;

            }
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println(Math.floor(2 / 3.0));
//        System.out.println(2/3);
        int[] a = {1};
        Arrays.sort(a);

        System.out.println(majorityElement(a));
    }
}
