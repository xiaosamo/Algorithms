package leetcode;

/**
 * @author yuan
 * @date 2019/8/25
 * @description
 */
public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        // 先求最长公共字符串长度
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 边界，当i=0 或 j=0,dp[i][j]= 0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }


    public static void main(String[] args) {
        两个字符串的删除操作 obj = new 两个字符串的删除操作();
        System.out.println(obj.minDistance("sea", "eat"));

    }

}
