package 排序算法;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/8/19
 * @description 快速排序
 */
public class QuickBeat {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (l < r) {
            int index = partition(a, l, r);
            sort(a, l, index - 1);
            sort(a, index + 1, r);
        }
    }

    /**
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于它的元素，
     * 交换这两个元素。不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。当两个指针相遇时，
     * 将切分元素 a[l] 和 a[j] 交换位置。
     * @param a
     * @param l
     * @param r
     * @return
     */
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
        swap(a, i, l);
        return i;
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
//        Arrays.sort(a);
        sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
        Integer[] b = {10};
//        quick.sort2(b, 0, b.length - 1);
//        quick.sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        sort(new Integer[]{}, 0, 0);

    }

}
