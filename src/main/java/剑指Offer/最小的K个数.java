package 剑指Offer;

import java.util.ArrayList;

/**
 * @author yuan
 * @date 2019/2/19
 * @description 基于partition，时间复杂度O(n)
 */
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>(input.length);
        if (k < 1 || k > input.length) {
            return result;
        }
        int l = 0, r = input.length - 1;
        int index = partition(input, l, r);
        while (index != k - 1) {
            if (index > k - 1) {
                r = index - 1;
                index = partition(input, l, r);
            } else {
                l = index + 1;
                index = partition(input, l, r);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    /**
     * 切片
     * @param a
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] a, int left, int right) {
        int i = left, j = right;
        int base = a[left];
        while (i < j) {
            while (i < j && a[j] >= base) {
                --j;
            }
            while (i < j && a[i] <= base) {
                ++i;
            }
            swap(a, i, j);
        }
        swap(a, left, i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        最小的K个数 obj = new 最小的K个数();
//        ArrayList<Integer> list = obj.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
//        ArrayList<Integer> list = obj.GetLeastNumbers_Solution(new int[]{1}, 1);
        ArrayList<Integer> list = obj.GetLeastNumbers_Solution(new int[]{1,2,3,4,5}, 3);
        list.forEach(i -> System.out.print(i + " "));

    }
}
