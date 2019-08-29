package 排序算法.demo;

import java.util.Arrays;


/**
 * @author yuanshijia                            
 * @date 2019-08-20
 * @description
 * 堆排序
 */
public class HeapSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        // 从非叶子节点开始，构建最大堆
        for (int i = n / 2; i >= 1; i--) {
            // 从右至左用sink()构造子堆
            sink(a, i, n);
        }
        // 此时a[1]为堆的最大元素，将a[1]与a[N]交换
        while (n > 1) {
            swap(a, 1, n);
            --n;
            sink(a, 1, n);
        }

    }

    /**
     * 如果一个节点比子节点小，需要不断进行比较和交换操作，这个操作就是下沉。
     * 如果有两个子节点，应当与大的子节点交换
     * @param a
     * @param k
     * @param n
     */
    private static void sink(Comparable[]a,int k,int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {

                ++j;
            }
            if (!less(a,k, j)) {
                return;
            }
            swap(a, k, j);
            k = j;
        }
    }

    private static void swap(Comparable[]a,int i,int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    private static boolean less(Comparable[] a, int i, int j) {

        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
