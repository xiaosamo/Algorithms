package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/12
 */
public class 字符串的最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        while (str1.contains(str2) || str2.contains(str1)) {
            while (str1.contains(str2)) {
                str1 = str1.substring(str2.length());
                if ("".equals(str1)) {
                    return str2;
                }
            }
            while (str2.contains(str1)) {
                str2 = str2.substring(str1.length());
                if ("".equals(str2)) {
                    return str1;
                }
            }
        }
        return "";
    }

    /**
     * 第2种方法
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings2(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public static void main(String[] args) {
        字符串的最大公因子 obj = new 字符串的最大公因子();
        System.out.println(obj.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(obj.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(obj.gcdOfStrings("LEET", "CODE"));
        System.out.println(obj.gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(obj.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        System.out.println(obj.gcdOfStrings("CXTXNCXTXNCXTXNCXTXNCXTXN",
                "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN"));
    }

}
