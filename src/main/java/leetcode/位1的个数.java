package leetcode;

public class 位1的个数 {
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ++ans;
            }
        }
        return ans;
    }

    public static int hammingWeight2(int n) {
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

    public static int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            // 只要整数n不等于0，则n至少有一位是1
            ++count;
            // 整数减1再和原来的树相与，相当于把整数二进制的最右边的1变成0
            n = n & (n - 1);
        }
        return count;
    }

        public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
