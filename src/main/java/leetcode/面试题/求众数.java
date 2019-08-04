package leetcode.面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/3
 * @description partition O(n)
 */
public class 求众数 {
    public int majorityElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        int index = partition(nums, l, r);
        int mid = nums.length >>> 1;
        while (index != mid) {
            if (index < mid) {
                // 在右边找
                index = partition(nums, index + 1, r);
            } else {
                // 在左边找
                index = partition(nums, l, index -1);
            }
        }
        return nums[mid];
    }


    private int partition(int[] a, int left, int right) {
        int i = left, j = right;
        int base = a[i];
        while (i < j) {
            while (i < j && a[j] >= base) {
                --j;
            }
            while (i < j && a[i] <= base) {
                ++i;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, left, i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        求众数 obj = new 求众数();
        int[] a = {3, 2, 3};
//        System.out.println(Arrays.toString(a));
        System.out.println(obj.majorityElement(new int[]{3, 2, 3}));
        System.out.println(obj.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }

}
