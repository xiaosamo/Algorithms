package 面试题.百度;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/24
 * @description
 */
public class 还原数列2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] a = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextBigInteger();
        }
        System.out.println(solve(a, n));
    }

    private static int solve(BigInteger[] a, int n) {
        Arrays.sort(a);
//        for (BigInteger i : a) {
//            System.out.println(i.toString());
//        }

        int cnt = 0;
        int i;
        for (i = n - 1; i >= 1; i--) {
            if (a[i].subtract(a[i - 1]).equals(BigInteger.ONE)) {
                ++cnt;

            } else {
                break;
            }
        }
        if (a[1].subtract(a[0]).equals(BigInteger.ONE)) {
            return cnt+1;
        }
        return cnt;
    }

    private static boolean isok(BigInteger[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i].compareTo(BigInteger.valueOf(n)) >= 0) {
                return false;
            }
        }
        return true;
    }
}
