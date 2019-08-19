package 排序算法;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-08-19
 * @description
 * 三向切分
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 */
public class ThreeWayQuickSort {
    public static void sort(Comparable[]a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (r >= l) {
            return;
        }
        int lt = l, i = l + 1, gt = r;
        Comparable base = a[l];
        while (i <= gt) {
            int cmp = a[i].compareTo(base);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, l, gt - 1);
        sort(a, gt + 1, r);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] a = {4, 5, 6, 3, 1, 3, 5, 6, 9, 7, 10};
        sort(a);

        System.out.println(Arrays.toString(a));
        Integer[] b = {10};

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


    }




}
