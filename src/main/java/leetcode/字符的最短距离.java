package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/1/20
 * @description
 */
public class 字符的最短距离 {
    public int[] shortestToChar(String S, char C) {
        int lastC = -1;

        int n = S.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (C == S.charAt(i)) {
                ans[i] = 0;
                if (lastC == -1) {
                    // 第一个出现的字符
                    for (int j = 0; j < i; j++) {
                        ans[j] = i - j;
                    }
                } else {
                    for (int j = lastC + 1; j < i; j++) {
                        ans[j] = Math.min(j - lastC, i - j);
                    }
                }
                lastC = i;
            }
        }
        // 处理最后的一个
        for (int i = lastC + 1; i < n; i++) {
            ans[i] = i - lastC;
        }
      //  System.out.println(Arrays.toString(ans));

        return ans;
    }

    public static void main(String[] args) {
        字符的最短距离 obj = new 字符的最短距离();
        obj.shortestToChar("loveleetcode", 'e');
        obj.shortestToChar("aaba", 'b');
    }
}
