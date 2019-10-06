package 面试题.深信服;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/6
 * @description
 */
public class IP段合并 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int b = in.nextInt();
            int e = in.nextInt();
            if (b < l) {
                l = b;
            }
            if (e > r) {
                r = e;
            }
            if (b >= l && b <= r) {
                r = Math.max(r, e);
            }

        }
        System.out.println(l + " " + r);
    }
}
