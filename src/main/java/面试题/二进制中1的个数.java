package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/3
 * @description
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * n & (n-1)表示二进制的最右边的1
     * @param n
     * @return
     */
    private static int solve2(int n) {
        int count = 0;
        while (n > 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }
}
