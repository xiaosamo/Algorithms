package leetcode;

public class 两整数之和 {
    public static int getSum(int a, int b) {
        if ((a & b) != 0) {
            // a^b 对于二进制的两个数加在一起，若没有进行进位，只要a和b的i为相同，那么总和的i位就是0，也就是抑或操作
            // a&b 进位
            return getSum((a & b) << 1, a ^ b);
        } else {
            return a | b;
        }
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, -2));
        System.out.println(getSum(1, -1));
    }
}
