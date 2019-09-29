package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 二进制中有多少个1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int ans =0;
        while (n > 0) {
            n = n & (n - 1);
            ++ans;
        }
        return ans;
    }


}
