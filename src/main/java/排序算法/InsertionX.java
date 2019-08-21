package 排序算法;

/**
 * @author yuan
 * @date 2019/2/23
 * @description InsertionSort，使用哨兵避免判断边界
 */
public class InsertionX {
    public static void sort(Comparable []a) {
        int N = a.length;
        // 向将最小的元素放置在数组的最左边
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (less(a[i], a[min])) {
                min = i;
            }
        }
        swap(a, min, 0);

        for (int i = 1; i < N; i++) {
            // 去掉j<0
            for (int j = i; less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
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
