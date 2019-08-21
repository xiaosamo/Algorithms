package 排序算法;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-08-21
 * @description 计数排序
 * 非比较的排序，复杂度O(n+k)，适用于在一定范围内的数
 * 改进版
 * https://juejin.im/post/5bdf13fe51882516f039ff7c
 * 局限性：
 * 1.当数列最大最小值差距过大时，并不适用计数排序。
 * 2.当数列元素不是整数，并不适用计数排序。
 */
public class CountSort {
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }
        //4.倒序遍历原始数列（保证稳定性），从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

}
