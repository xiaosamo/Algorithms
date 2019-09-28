package 面试题.百度;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/24
 * @description
 */
public class 还原数列 {
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
        if (isok(a,n)) {
            return 0;
        }

        int cnt = 0;
        while (!isok(a, n)) {
            BigInteger max = BigInteger.valueOf(-1);
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (a[i].compareTo(max) > 0) {
                    max = a[i];
                    index = i;
                }
            }
            a[index] = a[index].subtract(BigInteger.valueOf(n));

            for (int i = 0; i < n; i++) {
                if (i != index) {
                    a[i] = a[i].add(BigInteger.ONE);
                }
            }
            ++cnt;
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
