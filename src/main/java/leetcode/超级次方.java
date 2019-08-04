package leetcode;

import java.time.LocalDateTime;

public class 超级次方 {
    public int superPow(int a, int[] b) {
        int result = 1;
        for (int i = 0,len = b.length; i < len; i++) {
            result = pow(result, 10) * pow(a, b[i]) % 1337;
        }
        return result;
    }

    /**
     * 求x的n次方
     * @param x
     * @param n
     * @return
     */
    private int pow(int x, int n) {
        int result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = (result % 1337) * (x % 1337) % 1337;
            }
            x = (x % 1337) * (x % 1337) % 1337;
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {

        超级次方 obj = new 超级次方();
        System.out.println(obj.superPow(2, new int[]{1, 0}));
        System.out.println(obj.superPow(2147483647, new int[]{2, 0, 0}));

    }
    
}
