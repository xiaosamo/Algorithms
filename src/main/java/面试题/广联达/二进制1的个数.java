package 面试题.广联达;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/6
 * @description
 */
public class 二进制1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int count = 0;
        while (n > 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }
}
