package leetcode;

public class 判断子序列 {

    public static boolean isSubsequence(String s, String t) {
        // s字串
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        int p = 0, q = 0;
        int la = a.length, lb = b.length;
        while (p < la && q < lb) {
            if (a[p] == b[q]) {
                ++p;
                ++q;
            } else {
                ++q;
            }
        }

        return p == la;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
