package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.less;
import static 排序算法.Example.swap;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 * 选择排序，选择一个最小的，和第一个元素交换，然后继续选择第二小的，和第二个元素交换。。。
 *
 */
public class SelectionSort {
    public static void sort(Comparable[]a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[i])) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
