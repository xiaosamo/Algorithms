package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/3
 * @description
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        if (Double.compare(base, 0) == 0 && exponent < 0) {
            // 整数位0，指数为负数的情况
            throw new RuntimeException("非法输入，除数不能为0");
        }
        if (exponent < 0) {
            // 指数小于0
            return 1.0 / PowerWithUnsigned2(base, -exponent);
        }
        // 指数>0
        return PowerWithUnsigned2(base, exponent);
    }

    /**
     * O(n)
     * @param base
     * @param exponent
     * @return
     */
    private double PowerWithUnsigned(double base, long exponent) {
        double ans = 1;
        for (int i = 1; i <= exponent; i++) {
            ans = ans * base;
        }
        return ans;
    }

    /**
     * O(lgn)
     * a^n =
     * (a^n/2)*(a^n/2) n为偶数
     * a^(n-1)/2 * a^(n-1)/2 * a  n为奇数
     * @param base
     * @param exponent
     * @return
     */
    private double PowerWithUnsigned2(double base, long exponent) {
        // 边界
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // exponent >> 1 代替除以2
        double result = PowerWithUnsigned2(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            // 与运算代替 exponent % 2 == 1
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {
        数值的整数次方 obj = new 数值的整数次方();
        System.out.println(obj.Power(2, -3));

        System.out.println(Double.compare(1.03000000000000002f, 1.030000000000000000001f));
//        System.out.println(obj.Power(0, 0));
//        System.out.println(Math.pow(0, 0));
    }
}
