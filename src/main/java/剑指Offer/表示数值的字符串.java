package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/10
 * @description
 */
public class 表示数值的字符串 {

    private int index;

    /**
     * 数字的格式可以用：A[.[B]][e|EC]或.B[e|EC]表示，其中A和C都是整数（可以右正负号，也可以没有）
     * B是一个无符号整数
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        index = 0;
        // 扫描A部分
        boolean numeric = scanInteger(str);

        // 如果出现'.',接下来是数字的小数部分B
        if (index < str.length && str[index] == '.') {

            ++index;
            /**
             * 用||的原因：
             * 1.小数可以没有整数部分，如.123或0.123
             * 2.小数点后面可以没有数字，如233.等于233.0
             * 3.小数点前后都可以右数字，如233.666
             */
            numeric = scanUnsignedInteger(str) || numeric;
        }

        // 如果出现'e'或'E'，接下来是数字的指数部分C
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            ++index;
            /**
             * 用&&的原因:
             * 当e|E前面没有数字，整个字符串不能表示数字，如.e1、e1
             * 当e|E后面没有整数时，整个字符串不能表示数字，如12e、12e+5.4
             */
            numeric = numeric && scanInteger(str);
        }

        // 到结尾
        return numeric && index == str.length;
    }

    /**
     * 扫描字符串0~9的数（无符号的整数，匹配B部分）
     * @param str
     * @return 0~9位数大于0，返回true
     */
    private boolean scanUnsignedInteger(char[] str) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            ++index;
        }
        return index > before;
    }

    /**
     * 扫描以+或-开始的0~9的整数(带正负号的整数)，匹配A或C部分
     * @param str
     * @return
     */
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            ++index;
        }
        return scanUnsignedInteger(str);
    }



    public static void main(String[] args) {
        表示数值的字符串 obj = new 表示数值的字符串();
        System.out.println(obj.isNumeric(new char[]{'1', '2', 'e'}));
    }
}
