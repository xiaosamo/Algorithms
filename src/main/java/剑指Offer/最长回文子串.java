package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/4
 * @description
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int n = s.length();
        String revS = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n][n];
        int maxEnd = 0;
        int maxL = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (revS.charAt(i) == s.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;

                    }
                }
                // 记录下标
                if (dp[i][j] > maxL) {
                    maxEnd = i; //以 i 位置结尾的字符
                    maxL = dp[i][j];
                }
            }

        }

        return s.substring(maxEnd - maxL, maxEnd);
    }

    public static void main(String[] args) {
        最长回文子串 obj = new 最长回文子串();
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("a"));
        System.out.println(obj.longestPalindrome("ac"));
    }


}
