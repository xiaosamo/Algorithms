package 排序算法;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/24
 * @description 堆排序
 */
public class Heap {

    public static void sort(Comparable []a){
        int N = a.length;
        // 从非叶子节点开始，构建最大堆
        for (int k = N / 2; k >= 1; k--) {
            // 从右至左用sink()构造子堆
            sink(a, k, N);
            // 此时数组的每个位置都已经时一个子堆的根节点了
            // 如果一个节点的两个子节点都已经时堆，那么在该节点上调用sink()可以将它们变成一个堆
        }
        // 此时a[1]为堆的最大元素，将a[1]与a[N]交换
        while (N > 1) {
            // 将最大的元素a[1]和a[N]交换
            // 此时a[N]元素为有序，继续缩小N，找出次大的元素，直到全部有序
            swap(a, 1, N--);
            // 重新修复堆
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                ++j;
            }
            if (!less(a, k, j)) {
                break;
            }
            swap(a, k, j);
            k = j;
        }


    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }


    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }


    public static void main(String[] args) {
        Integer[] a = {5, 4, 1, 3, 5, 3, 1, 0, 3, 8};
        Heap.sort(a);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));

    }



}
