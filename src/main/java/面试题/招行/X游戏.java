package 面试题.招行;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 */
public class X游戏 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isok(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private static boolean isok(int n) {
        String old = String.valueOf(n);
        char[] chars = old.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '3' || chars[i] == '4' || chars[i] == '7') {
                return false;
            }
            if (chars[i] == '2') {
                chars[i] = '5';
            } else if (chars[i] == '5') {
                chars[i] = '2';
            } else if (chars[i] == '6') {
                chars[i] = '9';
            } else if (chars[i] == '9') {
                chars[i] = '6';
            }
            // 0, 1, 和 8 被旋转后仍然是它们自己
        }
        return !String.valueOf(chars).equals(old);
    }

}
