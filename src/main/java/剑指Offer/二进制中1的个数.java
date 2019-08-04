package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/2
 * @description
 */
public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            // 无符号右移，忽略符号位，空位都以0补齐
            n = n >>> 1;
        }
        return count;
    }

    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            // 只要整数n不等于0，则n至少有一位是1
            ++count;
            // 整数减1再和原来的数相与，相当于把整数二进制的最右边的1变成0
            n = n & (n - 1);
        }
        return count;
    }

    public int NumberOf3(int n) {
        return Integer.bitCount(n);
    }



        public static void main(String[] args) {
        二进制中1的个数 obj = new 二进制中1的个数();
        System.out.println(obj.NumberOf1(-3));
    }
}
