package leetcode;


/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class 通配符匹配 {
    /**
     * 令dp[i][j]表示字符串s前i个字符，和模式串p前j个字符的匹配情况，匹配就等于1，否则等于0。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 0 && p.charAt(j - 1) == '*' && dp[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    // 当前是'*'，匹配空字符串，或一段子串
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }


    private boolean isMatch(char a,char b){
        return a == b || b == '?';
    }

    public static void main(String[] args) {
        通配符匹配 obj = new 通配符匹配();
        System.out.println(obj.isMatch("aa", "a"));
        System.out.println(obj.isMatch("aa", "*"));
    }

}
