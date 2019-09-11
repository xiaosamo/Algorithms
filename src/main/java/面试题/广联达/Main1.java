package 面试题.广联达;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/6
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if ((n & 1) == 1) {
            return n - (n - 1) / 2;
        } else {
            return -n / 2;
        }
    }
}
