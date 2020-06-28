package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/20
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        int l = 0, r = arr.length - 1;
        int index = partition(arr, l, r);
        while (index != k - 1) {
            if (index > k-1) {
                r = index - 1;
            } else if (index < k - 1) {
                l = index + 1;
            }
            index = partition(arr, l, r);
        }
        return Arrays.copyOf(arr, index + 1); // index左边的就是都是小于k的
    }

    private int partition(int []a,int l,int r) {
        int base = a[l];
        int i=l,j=r;
        while (i < j) {
            while (i < j && a[j] >= base) {
                --j;
            }
            while (i < j && a[i] <= base) {
                ++i;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, l, i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        最小的k个数 obj = new 最小的k个数();
        System.out.println(Arrays.toString(obj.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }




}
