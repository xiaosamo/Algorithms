package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/31
 */
public class 排序数组 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int []a,int l,int r){
        if (l < r) {
            int index = partition(a, l, r);
            sort(a, l, index - 1);
            sort(a, index + 1, r);
        }

    }

    private int partition(int []a,int l,int r){
        int base = a[l];
        int i = l, j = r;
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
        swap(a, i, l);
        return i;
    }

    private void swap(int []a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        排序数组 obj = new 排序数组();
        System.out.println(Arrays.toString(obj.sortArray(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(obj.sortArray(new int[]{3})));
    }
}
