package leetcode;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
 */
public class 正则表达式匹配 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, s.length(), p, p.length());
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == 0) {
            return i == 0;
        }

        if (i == 0) {
            // 当s=""， p=a*这种情况，
            return j > 1 && p.charAt(j - 1) == '*' && isMatch(s, i, p, j - 2);
        }

        if (p.charAt(j - 1) != '*') {
            // 当p当前字符不是*,判断当前两个字符是否相等，如果相等，递归的比较前面的字符
            return isMatch(s.charAt(i - 1), p.charAt(j - 1)) && isMatch(s, i - 1, p, j - 1);
        }

        /**
         *  否则当前字符是*，进行两种尝试
         *  用*组合表示空字符串，看是否匹配
         *  用*组合表示一个字符串，看是否匹配
         */
        return isMatch(s, i, p, j - 2) || isMatch(s, i - 1, p, j) && isMatch(s.charAt(i - 1), p.charAt(j - 2));
    }

    private boolean isMatch(char a,char b){
        return a == b || b == '.';
    }

    /**
     * 如果模式串中有星号，它会出现在第二个位置，即pattern[1] 。这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即pattern[0] 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
     * @param s
     * @param p
     * @return
     */
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) {
//            return s.isEmpty();
//        }
//
//        // 匹配第一个字符
//        boolean firstMatch = (!s.isEmpty() && s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.';
//        if (p.length() >= 2 && p.charAt(1) == '*') {
//            // 注意，可以匹配0个的情况，即直接删掉；
//            return ( isMatch(s, p.substring(2))) || (firstMatch && isMatch(s.substring(1), p));
//        } else {
//            // 如果第一个字符相等，继续匹配下一个(删除掉前面的字符)
//            return firstMatch && isMatch(s.substring(1), p.substring(1));
//        }
//    }

//    public boolean isMatch(String s, String p) {
//        int i = 0, j = 0;
//        int m = s.length(), n = p.length();
//
//
//        while (i < m && j < n) {
//            if (j == n - 1 || p.charAt(j + 1) != '*') {
//                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
//                    ++i;
//                    ++j;
//                } else {
//                    return false;
//                }
//            } else if (j + 1 < n && p.charAt(j + 1) == '*') {
//                // 下一个是*
//                boolean flag = false;
//                while (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
//                    flag = true;
//                    ++i;
//                }
//                if (!flag) ++i;
//                j += 2;
//            }
//
//            if (i == m && j == n) {
//                return true;
//            }
//        }
//
//        return i == m && j == n;
//    }


    public static void main(String[] args) {
        正则表达式匹配 obj = new 正则表达式匹配();
        System.out.println(obj.isMatch("aa", "a"));
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("ab", ".*"));
        System.out.println(obj.isMatch("aaa", ".*"));
        System.out.println(obj.isMatch("mississippi", "mis*is*p*."));

        System.out.println(obj.isMatch("aaa", "a*a"));

//        System.out.println(obj.isMatch("ab", ".*c"));
    }
}
