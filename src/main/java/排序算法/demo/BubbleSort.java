package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.less;
import static 排序算法.Example.swap;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 */
public class BubbleSort {
    public static void sort(Comparable []a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
