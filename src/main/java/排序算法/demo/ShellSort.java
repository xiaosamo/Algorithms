package 排序算法.demo;

import java.util.Arrays;

import static 排序算法.Example.*;

/**
 * @author yuanshijia
 * @date 2019-08-20
 * @description
 * 插入排序对改进版
 * 对间隔h的序列排序，通过不断减小h直到为1，使得整个数组有序。
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
