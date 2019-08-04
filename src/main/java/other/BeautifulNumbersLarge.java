package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/11
 * @description 谷歌面试题
 */
public class BeautifulNumbersLarge {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            long n = in.nextInt();
            System.out.printf("Case #%d：%d\n", i, beautiful(n));
        }

    }

    /**
     * logN*loN*loN
     * 64*64*64 << 10*8
     * 枚举多少个1来求对应的进制
     * 十进制的数n在某个进制下是beautiful (全是1，以最多的1为优)
     * @param n 进制
     * @return
     */
    private static long beautiful(long n) {
        // 枚举1的个数，因为最多64个1
        // 这里从64开始，因为题目要求1越多越好
        for (int bits = 64; bits >= 2; bits--) {
            long rabix = getRadix(n, bits);
            if (rabix != -1) {
                return rabix;
            }
        }
        throw new IllegalStateException("Should not reach here.");
//        return n - 1;
    }

    /**
     *
     * 把n转换为bits个1，找到对应的进制
     * n很大
     * @param n
     * @param bits
     * @return
     */
    private static long getRadix(long n, int bits) {
        // 最小为2进制，最大为n-1进制
        long minRadix = 2;
        long maxRadix = n - 1;
        while (minRadix <= maxRadix) {
            long m = minRadix + (maxRadix - minRadix) / 2;
            // bits个1转出的结果
            long t = convert(m, bits);
            if (t < n) {
                // 如果值偏小，增加进制
                // convert是将111....1(bit 个 1)，N = 1 + r + r^2 + ... r^(k-1) ，N偏小，就增加r
                minRadix = m + 1;
            } else if (t > n) {
                maxRadix = m - 1;
            } else {
                // if t == n,说明就是m进制
                return m;
            }
        }
        // 转换失败
        return -1;
    }

    /**
     * return the value of 111...1(bit 1 in total) in radix
     * radix进制下，bits个1是多少
     * @param radix
     * @param bits
     * @return
     */
    private static long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        for (int i = 0; i < bits; i++) {
            // if component + sum > Long.Max
            // 说明溢出，
            if (Long.MAX_VALUE - sum < component) {
                sum = Long.MAX_VALUE;
            } else {
                sum += component;
            }

            if (Long.MAX_VALUE / component < radix) {
                // 如果这里溢出，需要返回sum，因为sum可能是最后的结果
                component = Long.MAX_VALUE;
            } else {
                component *= radix;
            }
        }
        return sum;
    }

}
