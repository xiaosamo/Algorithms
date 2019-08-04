package 剑指Offer;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/10
 * @description
 */
public class 调整数组顺序使奇数位于偶数前面2 {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int[] even = new int[array.length];
        int[] odd = new int[array.length];
        int index1 = 0, index2 = 0;

        for (int i = 0, len = array.length; i < len; i++) {
            if ((array[i] & 1) == 1) {
                // 奇数
                even[index1++] = array[i];
            } else {
                // 偶数
                odd[index2++] = array[i];
            }
        }
        for (int i = 0; i < index1; i++) {
            array[i] = even[i];
        }
        for (int i = 0; i < index2; i++) {
            array[index1 + i] = odd[i];
        }
    }

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面2 obj = new 调整数组顺序使奇数位于偶数前面2();
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        obj.reOrderArray(a);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));

    }
}
