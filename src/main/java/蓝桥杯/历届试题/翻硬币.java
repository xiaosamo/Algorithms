package 蓝桥杯.历届试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 */
public class 翻硬币 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();

        int[] a = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                a[i] = 0;
            } else {
                a[i] = 1;
            }
        }
        int i, j;
        int ans = 0;
        for (i = 0; i < s1.length(); ) {
            if (a[i] == 1) {
                for (j = i + 1; j < s1.length(); j++) {
                    if (a[j] == 1) {
                        ans += j - i;
                        i = j + 1;
                        // 记得跳出循环
                        break;
                    }
                }
            } else {
                ++i;
            }
        }
        System.out.println(ans);
    }
}
