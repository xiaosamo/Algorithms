package leetcode;

import java.util.Arrays;

public class 求众数 {
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int n = nums.length / 2;

//        for (int i = 0; i < nums.length; i++) {
////            System.out.println("left=" + binearyLeft(nums, nums[i]) + ", right= " + binearyRight(nums, nums[i]));
//            if (binearyRight(nums, nums[i]) - binearyLeft(nums, nums[i]) > n) {
//                return nums[i];
//            }
//        }
//        return -1;

        return nums[n];
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
        int l = 0, r = a.length ;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] <= k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(majorityElement(a));

//
//        System.out.println(binearyLeft(a, 2));
//        System.out.println(binearyRight(a, 2));

    }
}
