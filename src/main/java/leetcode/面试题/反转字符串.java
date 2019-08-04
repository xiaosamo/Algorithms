package leetcode.面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int n = s.length;
        if (n == 0) {
            return;
        }

        for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    public static void main(String[] args) {
        反转字符串 obj = new 反转字符串();

        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        obj.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
