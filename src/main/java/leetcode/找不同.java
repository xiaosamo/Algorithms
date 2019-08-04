package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class 找不同 {
    public static char findTheDifference(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        String str = String.valueOf(cht);
        return str.charAt(str.length() - 1);
//        System.out.println(String.valueOf(ch));
//        return 'c';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));

    }
}
