package 蓝桥杯.模拟;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class 找质数2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        for (int i = 2; i < n; i++) {
            if (isprime(i) && isprime(n - i)) {
                System.out.println(i + " " + (n - i));
                return;
            }
        }
    }

    private static boolean isprime(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
