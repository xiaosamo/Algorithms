package leetcode;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        int len = first.length > last.length ? last.length : first.length;
        for (int i = 0; i < len; i++) {
            if (first[i] == last[i]) {
                result.append(first[i]);
            } else {
                break;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
//        char[] s = "aaab".toCharArray();
//        System.out.println(s.length);
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
