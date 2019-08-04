package leetcode;

import java.math.BigInteger;

public class 二进制求和 {
    public static String addBinary(String a, String b) {
        // 二进制转十进制
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);
        a1 = a1.add(b1);
        // 十进制转二进制
        return a1.toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));

    }


}
