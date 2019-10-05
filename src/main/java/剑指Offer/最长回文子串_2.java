package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/4
 * @description
 * 中心扩展法
 * 回文中心的两侧互为镜像。因此，回文可以从他的中心展开，并且只有 2n-1 个这样的中心（一个元素为中心的情况有 n 个，两个元素为中心的情况有 n-1 个）
 */
public class 最长回文子串_2 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();

        int maxL = 0; //记录最大回文子串的长度
        int start = 0; // 记录回文子串起始位置
        int end=0;    // 记录回文子串终止位置
        for(int i=0;i<s.length();i++){
            int len1 = expendaroundcenter(chars, i, i); //一个元素为中心
            int len2 = expendaroundcenter(chars, i, i + 1); //一个元素为中心
            maxL = Math.max(Math.max(len1, len2), maxL);
            if (maxL > end - start + 1) {
                start = i - (maxL - 1) / 2;
                end = i + maxL / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expendaroundcenter(char[] str, int l, int r) {
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            l--;
            r++;
        }
        return r - l - 1; // 注意这里是-1，不是+1，因为l,r都会多走一步
    }

    public static void main(String[] args) {
        最长回文子串_2 obj = new 最长回文子串_2();
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("a"));
        System.out.println(obj.longestPalindrome("ac"));
        System.out.println(obj.longestPalindrome("abb"));
    }


}
