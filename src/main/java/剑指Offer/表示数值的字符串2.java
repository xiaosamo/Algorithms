package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/10
 * @description
 */
public class 表示数值的字符串2 {
    /**
     * 1. 使用正则表达式匹配
     * 数字的格式可以用：A[.[B]][e|EC]或.B[e|EC]表示，其中A和C都是整数（可以右正负号，也可以没有）
     * @param str
     * @return
     */
    //
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
