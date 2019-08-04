package 基础练习;

public class 二分查找递归实现 {
    public static int binarySearch(int key, int[] a, int left, int right) {
        if (left > right) {
            return -1;
        }
        int m = left + (right - left) / 2;
        if (a[m] > key) {
            return binarySearch(key, a, left, m - 1);
        } else if (a[m] < key) {
            return binarySearch(key, a, m + 1, right);
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(5, a, 0, a.length - 1));
    }
}
