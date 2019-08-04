package 蓝桥杯;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 母牛的故事 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                return;
            }
            System.out.println(f(n));
        }
    }



    public static int f(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < 4) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
        }
        return dp[n];
    }

}
