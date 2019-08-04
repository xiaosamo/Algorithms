package 剑指Offer;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/10
 * @description
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int left = 0, right = array.length - 1;
        while (left < right) {
            // 如果left指针指向的为奇数，left后移
            while (left < right && (array[left] & 1) == 1) {
                ++left;
            }

            // 如果right指针指向的为偶数，right前移
            while (left < right && (array[right] & 1) == 0) {
                --right;
            }

            // 交换
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        // 排序
        int m = array.length / 2;
        if ((m & 1) == 1) {
            ++m;
        }
        Arrays.sort(array, 0, m );
        Arrays.sort(array, m, array.length);
    }

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面 obj = new 调整数组顺序使奇数位于偶数前面();
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        obj.reOrderArray(a);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));

    }
}
