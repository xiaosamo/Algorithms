package leetcode;

public class 求x的n次方 {

    public  double myPow(double x, int n) {
        if (Double.compare(x, 0) == 0 && n < 0) {
            // 整数位0，指数为负数的情况
            throw new RuntimeException("非法输入，除数不能为0");
        }
        long N = n; // 防止溢出
        if (N < 0) {
            // 负数
            return 1.0 / PowerWithUnsigned2(x, -N);
        }
        // 正数
        return PowerWithUnsigned2(x, N);
    }
    /**
     * 递归 O(lgn)
     * a^n =
     * (a^n/2)*(a^n/2) n为偶数
     * a^(n-1)/2 * a^(n-1)/2 * a  n为奇数
     * @param x
     * @param n
     * @return
     */
    private double PowerWithUnsigned(double x, long n) {
        // 边界
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        // exponent >> 1 代替除以2
        double result = PowerWithUnsigned(x, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            // 与运算代替 exponent % 2 == 1
            result *= x;
        }
        return result;
    }

    /**
     * 非递归
     * @param x
     * @param n
     * @return
     */
    private double PowerWithUnsigned2(double x, long n) {
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        求x的n次方 obj = new 求x的n次方();
//        System.out.println(obj.myPow(2, 10));
//        System.out.println(obj.myPow(2.1, 3));
//        System.out.println(obj.myPow2(2, -2));
        System.out.println(obj.myPow(1.0, -2147483648));
//        System.out.println(obj.myPow2(0.4321, 20));


//        System.out.println(3 & 1);
//        System.out.println(myPow(0, -1));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

    }
}
