package 面试题._58;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/13
 * @description
 */
public class 数组出现的次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int x = in.nextInt();

        solve(m, n, x);

    }

    private static void solve(int m, int n, int x) {
        StringBuilder sb = new StringBuilder();
        char c = (char) (x + '0');
        for (int i = m; i <= n; i++) {
            sb.append(i);
        }
        int len = sb.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == c) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
