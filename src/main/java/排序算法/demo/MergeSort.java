package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.less;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 * 归并排序
 * 将数组分为两部分，分别排序，在合并为一个有序数组
 * 需要辅助空间
 */
public class MergeSort {
    private static Comparable[] aux;
    public static void sort(Comparable[]a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(Comparable[] a, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            aux[k] = a[k];
        }

        for (int k = l; k <= r; k++) {
            if (i > m) {
                a[k] = aux[j++];
            } else if (j > r) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
