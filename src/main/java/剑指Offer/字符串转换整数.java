package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/21
 * @description
 */
public class 字符串转换整数 {
    public int myAtoi(String str) {
        if ("".equals(str)) {
            return 0;
        }
        int j=0;
        char[] chars = str.toCharArray();
        int len = str.length();
        while (j < len && chars[j] == ' ') {
            ++j;
        }
        boolean flag = false; // 负数
        if (j < len && chars[j] == '-') {
            flag = true;
            ++j;
        } else if (j < len && chars[j] == '+') {
            ++j;
        }

        long num = 0;
        for (int i = j; i < len; i++) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            num = num * 10 + (chars[i] - '0');

            if (num > Integer.MAX_VALUE) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }else if (num < Integer.MIN_VALUE) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        num = flag? -num:num;
        return (int) num;
    }

    public static void main(String[] args) {
        字符串转换整数 obj = new 字符串转换整数();
//        System.out.println(obj.myAtoi("4193 with words"));
//        System.out.println(obj.myAtoi("words and 987"));
//        System.out.println(obj.myAtoi("-91283472332"));
//        System.out.println(obj.myAtoi(""));
//        System.out.println(obj.myAtoi(" "));
//        System.out.println(obj.myAtoi("  +1"));
//        System.out.println(obj.myAtoi("9223372036854775808"));
        System.out.println(obj.myAtoi("-91283472332"));
    }
}
