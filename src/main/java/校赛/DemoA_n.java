package 校赛;

import leetcode.求x的n次方;

import java.math.BigDecimal;

/**
 * @author yuan
 * @date 2019/2/23
 * @description
 */
public class DemoA_n {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = myPow(x, n/2);
        if ((n & 1) == 1) {
            return result * result;
        } else if ((n & 1) == 0) {
            return result * result * x;
        }
        return result * result / x;
    }


    public  double myPow2(double x, int n) {
        if (Double.compare(x, 0) == 0 && n < 0) {
            // 整数位0，指数为负数的情况
            throw new RuntimeException("非法输入，除数不能为0");
        }
        long absN = n;
        if (n < 0) {
            // 负数
            absN = -absN;
            return 1.0 / PowerWithUnsigned2(x, absN);
        }
        // 正数
        return PowerWithUnsigned2(x, absN);
    }

    /**
     * 递归 O(lgn)
     * a^n =
     * (a^n/2)*(a^n/2) n为偶数
     * a^(n-1)/2 * a^(n-1)/2 * a  n为奇数
     * @param base
     * @param exponent
     * @return
     */
    private double PowerWithUnsigned(double base, long exponent) {
        // 边界
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // exponent >> 1 代替除以2
        double result = PowerWithUnsigned(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            // 与运算代替 exponent % 2 == 1
            result *= base;
        }
        return result;
    }

    /**
     * 非递归
     * @param base
     * @param exponent
     * @return
     */
    private double PowerWithUnsigned2(double base, long exponent) {
        double result = 1;
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        DemoA_n obj = new DemoA_n();
//        System.out.println(obj.myPow(2, 10));
//        System.out.println(obj.myPow(2.1, 3));
//        System.out.println(obj.myPow2(2, -2));
//        System.out.println(obj.myPow2(1.0, -2147483648));
        System.out.println();
        double ans = obj.myPow2(0.4321, 20);
        BigDecimal b = new BigDecimal(ans);
        System.out.println("0.00000005148554641076956121994511276767154838481760200726351203835429763013462401");
        BigDecimal bigDecimal = new BigDecimal(0.4321);
        System.out.println(b.toPlainString());
        System.out.println(bigDecimal.pow(20).toPlainString().substring(0, 80));

//        System.out.println(b.longValue());


//        System.out.println(myPow(0, -1));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

    }
}
