package leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/3/19
 */
public class 最长回文串 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        最长回文串 obj = new 最长回文串();
        System.out.println(obj.longestPalindrome("abccccdd"));
    }
}
