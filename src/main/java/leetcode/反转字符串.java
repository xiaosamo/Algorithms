package leetcode;

import java.util.Arrays;

public class 反转字符串 {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        for (int i = 0; i < N / 2; i++) {
            char t = chars[i];
            chars[i] = chars[N - i - 1];
            chars[N - i - 1] = t;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }


}
