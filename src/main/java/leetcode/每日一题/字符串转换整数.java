package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/3
 */
public class 字符串转换整数 {
    public int myAtoi(String str)
    {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }

        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }

        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }


        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

    public static void main(String[] args) {
        字符串转换整数 obj = new 字符串转换整数();
//        System.out.println(obj.myAtoi(" 42"));
//        System.out.println(obj.myAtoi("4193 with words"));
//        System.out.println(obj.myAtoi("words and 987"));
//        System.out.println(obj.myAtoi("-91283472332"));
//        System.out.println(obj.myAtoi("-912"));
//        System.out.println(obj.myAtoi("-9129"));
//        System.out.println(obj.myAtoi("+1"));
//        System.out.println(obj.myAtoi("-  234"));
        System.out.println(obj.myAtoi("  -42"));
    }
}
