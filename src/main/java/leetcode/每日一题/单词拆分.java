
package leetcode.每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/6/25
 */
public class 单词拆分 {


    /**
     * 动态规划
     * dp[i]表示前i个字符串是否可被wordDict拆分
     * dp[i]=dp[j] && check(s[j..i−1])
     *
     * 其中 check表示子串 s[j..i-1]s[j..i−1] 是否出现在字典中。
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0]=true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {

        System.out.println(new 单词拆分().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new 单词拆分().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new 单词拆分().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new 单词拆分().wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        System.out.println(new 单词拆分().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
