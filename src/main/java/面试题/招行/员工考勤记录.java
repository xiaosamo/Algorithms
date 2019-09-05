package 面试题.招行;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 */
public class 员工考勤记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(solve(n));
    }

    /**
     * 就是求C(n, 0) + C(n, 1) + C(n, 2)
     * = 1 + n + n(n-1)/2
     * @param n
     * @return
     */
    private static long solve(int n) {
        return 1 + n + n * (n - 1) / 2;
    }

}
