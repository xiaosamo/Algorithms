package leetcode;

public class 字符串转换整数 {
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int l = chars.length;
        long result = 0;
        boolean hasNum = false;
        // 负数
        Boolean flag = null;
        for (int i = 0; i < l; i++) {
            char c = chars[i];
//            boolean isNum = false;
            if (c == ' ') {
                if (hasNum || flag != null) {
//                    return (int) result;
                    if (flag != null && flag) {

                        return (int) -result;

                    } else {
                        return (int) result;
                    }
//                    return (int) (flag ? -result : result);

                }

                continue;
            }

            if (c == '+') {
                if (i - 1 >= 0 && chars[i - 1] >= '0' && chars[i - 1] <= '9') {
                    return 0;
                }
                if (flag != null) {
                    return (int) (flag ? -result : result);

                }
                flag = false;
                continue;
            }
            if (c == '-') {

                if (i - 1 >= 0 && chars[i - 1] >= '0' && chars[i - 1] <= '9') {
                    return 0;
                }

                if (flag != null) {
                    return (int) (flag ? -result : result);
                }
                flag = true;
                continue;
            }

            if (c >= '0' && c <= '9') {
                result = result * 10 + (chars[i] - '0');
//                x *= 10;
//                isNum = true;
                hasNum = true;
                continue;
            }

//            if (!isNum) {
                break;
//            }


        }

        flag = (flag == null ? false : flag);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return (int) (flag ? -result : result);
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("+1"));
//        System.out.println(myAtoi("+-2"));
//        System.out.println(myAtoi("   +0 123"));
//        System.out.println(myAtoi("-   234"));
//        System.out.println(myAtoi("0-1"));
//        System.out.println(myAtoi("    -88827   5655  U"));
        System.out.println(myAtoi("-5-"));

    }
}
