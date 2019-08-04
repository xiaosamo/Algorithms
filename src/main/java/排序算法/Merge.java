package 排序算法;

/**
 * @author yuan
 * @date 2019/2/23
 * @description 归并排序：将数组分为两半分别排序，然后将结果归并起来
 * 缺点：所需的额外空间与N成正比
 */
public class Merge {

    /**
     * 归并所需的辅组空间
     */
    private static Comparable[] aux;

    public static void sort(Comparable []a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            // 将左半边排序
            sort(a, l, mid);
            // 将右半边排序
            sort(a, mid + 1, r);
            // 归并结果
            merge(a, l, mid, r);
        }
    }

    /**
     * 归并
     * @param a
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] a, int l, int mid, int r) {
        // a[l...mid]和a[mid+1..r]为有序，归并
        int i = l, j = mid + 1;
        // 将a[l...r]复制到aux[l...r]
        for (int k = l; k <= r; k++) {
            aux[k] = a[k];
        }

        // 归并回到a[l...r]
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 左半边用尽，取右边的元素
                a[k] = aux[j++];
            } else if (j > r) {
                // 右半边用尽，取左边的元素
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                // 右半边的当前元素小于左边的当前元素（取右半边的元素）
                a[k] = aux[j++];
            } else {
                // 右半边的当前元素大于等于左边的当前元素（取左半边的元素）
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
