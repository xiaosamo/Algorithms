package leetcode;

import java.util.Arrays;

/**
 * 原地算法
 */
public class 删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] = Integer.MIN_VALUE;
            }
        }
        Arrays.sort(nums);
        int len = 0;
        int flag = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                ++len;
                if (flag < 0) {

                    flag = i;
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println("len=" + len + ",flag=" + flag);
        for (int i = flag, j = 0; i < flag + len; i++, j++) {
            nums[j] = nums[i];
        }
        return len;
    }

    public static int removeDuplicates2(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[number]) {
                ++number;
                nums[number] = nums[i];
            }
        }
        return number + 1;

    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3};
//        int[] a = {1, 2};
        int len = removeDuplicates2(a);
        for (int i = 0; i < len; i++) {
            System.out.println(a[i]);
        }
    }
}
