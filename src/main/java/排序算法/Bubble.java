package 排序算法;

import java.util.Arrays;

import static 排序算法.Example.less;
import static 排序算法.Example.swap;

/**
 * @author yuan
 * @date 2019/2/17
 * @description 冒泡排序
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
public class Bubble {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (less(a[j + 1], a[j])) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        Integer[] a = {1, 5, 6, 3, 1, 3, 5, 6, 9, 7, 10, -1, -2, 0};
        Integer[] b = {10};
        sort(a);
        sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}
