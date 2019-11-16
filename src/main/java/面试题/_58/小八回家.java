package 面试题._58;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/13
 * @description
 */
public class 小八回家 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = a+b;
            a=b;
            b=ans;
        }
        return ans;
//        return solve(n - 1) + solve(n - 2);
    }
}
