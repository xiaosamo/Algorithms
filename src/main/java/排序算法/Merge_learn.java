package 排序算法;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-08-19
 * @description
 */
public class Merge_learn {
    private static Comparable[] aux;

    public static void sort(Comparable []a){
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
         int i=l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            aux[k] = a[k];
        }

        for (int k = l; k <= r; k++) {
            if (i > m) {
                a[k] = aux[j++];
            } else if (j > r) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4, -1, 0, 5, 3, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
