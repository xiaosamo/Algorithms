package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.less;
import static 排序算法.Example.swap;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 * 将右边的元素插入到左边已经有序到集合中
 */
public class InsertionSort {
    public static void sort(Comparable[]a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
