package 排序算法;

/**
 * @author yuan
 * @date 2019/2/22
 * @description 选择排序：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它和自己交换），再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换，如此往复，直到将整个数组排序。
 */
public class Selection {
    public static void sort(Comparable []a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1...N]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
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
