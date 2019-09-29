package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 被3整除 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l= in.nextInt();
        long r = in.nextInt();

//        String s1 = "";
//        for (int i = 1; i <= l; i++) {
//            s1 += i;
//        }
//
//        String s2 = "";
//        for (int i = 1; i <= r; i++) {
//            s2 += i;
//        }

//        solve(r);
        System.out.println(solve(r) - solve(l - 1));

    }

    private static int solve(long r) {
        long sum = 0;
        int ans = 0;
        for (long i = 1; i <= r; i++) {
            sum +=i;
            if (sum % 3 == 0) {
                ++ans;
            }
        }
//        System.out.println(sum);
        return ans;
    }
}
