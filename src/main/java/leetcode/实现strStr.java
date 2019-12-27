package leetcode;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class 实现strStr {
    /**
     * 暴力法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int curI = i,j=0;
            while (j < needle.length() && curI < haystack.length()) {
                if (haystack.charAt(curI) == needle.charAt(j)) {
                    ++curI;
                    ++j;
                } else {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
            if (curI == haystack.length()) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("", "a"));
//        System.out.println(strStr("aaa", "aaaa"));
//        System.out.println(strStr("mississippi", "issipi"));
    }
}
