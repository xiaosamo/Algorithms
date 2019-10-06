package 面试题.深信服;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/6
 * @description
 */
public class 子串模糊匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        char[] sub = in.next().toCharArray();

        int i = 0, j = 0;
        int maxL = 0;
        while (i < chars.length && j < sub.length) {
            if (chars[i] == sub[j]) {
                ++i;
                ++j;
                maxL = 0;
            } else if (sub[j] == '?') {
                maxL = 3;
                ++i;
                ++j;
                --maxL;
            } else if (maxL > 0) {
                ++i;
                --maxL;
            } else {
                System.out.println("-1");
                return;
            }
        }
        if (j >= sub.length) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}
