package 排序算法.demo;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-08-21
 * @description
 */
public class CountSort {
    public static int[] sort(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }
        int d = max - min;
        int[] countArray = new int[d + 1];
        for (int i = 0; i < a.length; i++) {
            countArray[a[i] - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] res = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            res[countArray[a[i] - min] - 1] = a[i];
            countArray[a[i] - min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
