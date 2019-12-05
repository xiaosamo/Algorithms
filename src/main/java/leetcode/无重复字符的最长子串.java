package leetcode;

import java.util.HashSet;

/**
 * @author yuan
 * @date 2019/12/5
 * @description
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        // i是慢指针，j是快指针
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                ++i;
            }
            set.add(s.charAt(j));// 加入快指针的字符
            max = Math.max(max, set.size());
        }
        return max;
    }
}
