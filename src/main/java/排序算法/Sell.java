package 排序算法;

/**
 * @author yuan
 * @date 2019/2/23
 * @description ShellSort：为了加快速度简单地改进了插入排序，交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部有序的数组排序。
 * 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。排序时，如果h很大，就能将元素移动到很远的地方。
 */
public class Sell {
    public static void sort(Comparable []a) {
        int N = a.length;
        int h = 1;
        // 1, 4, 13, 40, ...
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
