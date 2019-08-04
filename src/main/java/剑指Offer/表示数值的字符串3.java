package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/10
 * @description
 */
public class 表示数值的字符串3 {
    // 1.利用系统自身的校验机制。
    public boolean isNumeric(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


}
