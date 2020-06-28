package leetcode.每日一题;


/**
 * @author yuan
 * @date 2020/6/15
 * https://leetcode-cn.com/problems/longest-common-prefix/submissions/
 */
public class 最长公共前缀 {

    /**
     * 纵向扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        int length = s.length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            for (int j = 1; j < count; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

    /**
     * 当前s不是ans的前缀，开始减去ans最后一个字符
     * 然后继续尝试
     * https://leetcode-cn.com/problems/longest-common-prefix/solution/cdai-ma-by-orange-32-4/
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (String s : strs) {
            while (s.indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new 最长公共前缀().longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        System.out.println(new 最长公共前缀().longestCommonPrefix2(new String[]{"dog","racecar","car"}));
        System.out.println(new 最长公共前缀().longestCommonPrefix2(new String[]{"","b"}));
        System.out.println(new 最长公共前缀().longestCommonPrefix2(new String[]{"aa","a"}));
        System.out.println(new 最长公共前缀().longestCommonPrefix2(new String[]{"aca","cba"}));
    }
}
