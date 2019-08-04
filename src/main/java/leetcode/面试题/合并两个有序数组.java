package leetcode.面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/4
 * @description
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] a = new int[m + n];
        int i=0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            while (i < m && nums1[i] <= nums2[j]) {
                a[k++] = nums1[i++];
            }
            while (j < n && nums2[j] <= nums1[i]) {
                a[k++] = nums2[j++];
            }
            if (i == m) {
                while (j < n) {
                    a[k++] = nums2[j++];
                }
            } else if (j == n) {
                while (i < m) {
                    a[k++] = nums1[i++];
                }
            }
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = a[i];
        }
//        Arrays.stream(nums1).forEach(t -> System.out.print(t + " "));
    }

    public static void main(String[] args) {
        合并两个有序数组 obj = new 合并两个有序数组();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        obj.merge(nums1, 3, nums2, 3);
        obj.merge(new int[]{1}, 1, new int[]{}, 0);

    }
}
