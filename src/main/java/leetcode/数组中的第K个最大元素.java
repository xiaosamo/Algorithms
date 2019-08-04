package leetcode;


/**
 * @author yuan
 * @date 2019/2/19
 * @description 使用快排
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 找第k大的元素相当于找第len - k + 1小的元素
        k = nums.length - k + 1;

        int l = 0, r = nums.length - 1;
        int index = partition(nums, l, r);
        while (index != k - 1) {
            if (index > k - 1) {
                r = index - 1;
                index = partition(nums, l, r);
            } else {
                l = index + 1;
                index = partition(nums, l, r);
            }
        }
        return nums[index];
    }


    private int partition(int[] a, int l, int r) {
        int i = l, j = r;
        int base = a[l];
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
        swap(a, l, i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
