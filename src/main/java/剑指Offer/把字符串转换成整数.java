package 剑指Offer;

/**
 * @author yuan
 * @date 2019/9/21
 * @description
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean isNegative = chars[0] == '-';
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[0] == '+' || chars[0] == '-')) {
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') {
                // 不合法
                return 0;
            }
            result = result * 10 + (chars[i] - '0');
        }
        return isNegative ? -result : result;
    }
}
