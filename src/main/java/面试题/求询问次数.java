package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/19
 * @description
 */
public class 求询问次数 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 1 << n;
        int cnt = 0;
        while (max > 1) {
            ++cnt;
            max /= 2;
        }
        System.out.println(cnt);
        int mod = 1000003;
        int ans = 1;
        for (int i = n; i >= 1; i--) {
            ans = (ans % mod) * (i % mod) % mod;
        }
        System.out.println(ans);

//        int max = 1 << n;
//        for (int i = 0; i < max; i++) {
//        }
//        int l = 0, r = max;
//        while (l < r) {
//            int m = l + (r - l) / 2;
//            if () {
//            }
//            System.out.println(m);
//        }
//        System.out.println(1&3);
//        System.out.println(2&3);
//        System.out.println(4&3);
    }
}
