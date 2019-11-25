package leetcode;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
 */
public class 正则表达式匹配 {
    /**
     * 如果模式串中有星号，它会出现在第二个位置，即pattern[1] 。这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即pattern[0] 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // 匹配第一个字符
        boolean firstMatch = (!s.isEmpty() && s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.';
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 注意，可以匹配0个的情况，即直接删掉；
            return ( isMatch(s, p.substring(2))) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            // 如果第一个字符相等，继续匹配下一个(删除掉前面的字符)
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        正则表达式匹配 obj = new 正则表达式匹配();
//        System.out.println(obj.isMatch("aa", "a"));
//        System.out.println(obj.isMatch("aa", "a*"));
//        System.out.println(obj.isMatch("ab", ".*"));
//        System.out.println(obj.isMatch("aaa", ".*"));
//        System.out.println(obj.isMatch("mississippi", "mis*is*p*."));
        System.out.println(obj.isMatch("ab", ".*c"));
    }
}
