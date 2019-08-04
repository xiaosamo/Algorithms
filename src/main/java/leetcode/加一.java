package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/13
 * @description
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int index = digits.length - 1;
        digits[index]++;

        // 如果不需要进位，直接返回
        if (digits[index] < 10) {
            return digits;
        }
        // 否则需要进位
        int s = 0;
        for (int i = index; i >= 0; i--) {
            digits[i] = digits[i] + s;
            s = 0;
            if (digits[i] > 9) {
                s = digits[i] / 10;
                digits[i] %= 10;
            }
        }

        // 需要添加位
        if (s > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = s;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        加一 obj = new 加一();
        obj.plusOne(new int[]{1, 2, 3});
        obj.plusOne(new int[]{9,9,9});


    }
}
