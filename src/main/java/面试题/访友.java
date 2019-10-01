package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 访友 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        int[] a = {5, 4, 3, 2, 1};
        int ans = 0;
        while (x != 0) {
            for (int i = 0; i < a.length; i++) {
                if (x >= a[i]) {
                    ans += x / a[i];
                    x %= a[i];

                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
