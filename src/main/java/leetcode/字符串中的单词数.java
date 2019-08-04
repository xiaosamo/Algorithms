package leetcode;

import java.util.Arrays;

public class 字符串中的单词数 {
    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");
//        System.out.println(Arrays.toString(split));
        return split.length;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));

    }
}
