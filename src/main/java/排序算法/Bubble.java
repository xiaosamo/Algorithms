package 排序算法;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/17
 * @description 冒泡排序
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 */
public class Bubble {
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
//            for (int j = i; j < n - 1; j++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] a = {1, 5, 6, 3, 1, 3, 5, 6, 9, 7, 10};
        int[] b = {10};
        bubble.sort(a);
        bubble.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        bubble.sort(new int[]{});
    }
}
