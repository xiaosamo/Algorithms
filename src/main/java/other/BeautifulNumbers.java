package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/11
 * @description 谷歌面试题
 * 13 -> 3 > 111 (right)
 * 13 -> 12 > 11  (error)
 */
public class BeautifulNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = in.nextInt();
            System.out.printf("Case #%d：%d\n", i, beautiful(n));
        }

    }

    /**
     * O(NlogN)
     * 十进制的数n在某个进制下是beautiful (全是1，以最多的1为优)
     * @param n 进制
     * @return
     */
    private static int beautiful(int n) {
        // 循环到n-1进制，对于任意n都有解
        // 例如1000,在999进制下是11
        for (int radix = 2; radix < n; radix++) {
            // if n is 11 in radix, return radix
            if (isBeautiful(n, radix)) {
                return radix;
            }
       }
        throw new IllegalStateException("Should not reach here.");
//        return n - 1;
    }

    private static boolean isBeautiful(int n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                // if has one is not 1, return false
                return false;
            }
            n /= radix;
        }
        // here n is 0
        return true;
    }

}
