package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 数对 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j >= k) {
                    ++ans;
//                    System.out.println(i + " " + j);
                }
            }
        }
        System.out.println(ans);

    }
}
