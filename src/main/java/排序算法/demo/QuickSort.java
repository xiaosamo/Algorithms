package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.less;
import static 排序算法.Example.swap;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 * 快速排序
 * 选择一个基数，使得这个基数左边到数都比它小，右边的数都比它大，
 * 然后在递归对这两个子数组排序，最后整个数组都有序了。
 */
public class QuickSort {
    public static void sort(Comparable[]a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (l < r) {
            int index = partition(a, l, r);
            sort(a, l, index - 1);
            sort(a, index + 1, r);
        }
    }

    private static int partition(Comparable[] a, int l, int r) {
        Comparable base = a[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[j].compareTo(base) >= 0) {
                --j;
            }
            while (i < j && a[i].compareTo(base) <= 0) {
                
                ++i;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, l, i);
        return i;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
