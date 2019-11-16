package 面试题.有赞;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            long n = in.nextLong();
            System.out.println(solve(n));
//            System.out.println(solve2(n));
        }
//        for (int i = 1; i <= 100; i++) {
//            System.out.println(solve2(i));
//        }
    }

    private static int solve(long n) {
        int ans = 0;
        int m = (int) (n / 2) + 1;
        for (int i = 1; i <= n; i++) {
            int j = (int) (n / i - 2);
            if (j >= i) {
                ++ans;
            }
        }

        return ans;
    }

    private static int solve2(long n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i * j + i + j == n) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}