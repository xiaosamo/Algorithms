package leetcode;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * 动态规划
 */
public class 正则表达式匹配_ {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // 两个字符串都为空，为true


        // 当s为空，对p字符串的任一位置，子串都得是一系列的*组成
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    // 匹配空字符串，或表示一个字符
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && isMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }

        return dp[m][n];
    }

    private boolean isMatch(char a,char b){
        return a == b || b == '.';
    }


}
