package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/10/4
 * @description
 */
public class 无重复字符的最长子串 {
    /**
     * 使用滑动窗口
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int ans = 0, i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                // 右移
                ans = Math.max(ans, j - i + 1);
                set.add(s.charAt(j++));
            } else {
                // 左移
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        无重复字符的最长子串 obj = new 无重复字符的最长子串();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbbb"));
    }
}
