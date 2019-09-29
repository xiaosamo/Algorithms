package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 * 输入两个字符串a和b，字符串内容为二进制数字，求两个字符串相加的结果，加法计算方法以二进制方式计算，并返回对应的字符串结果。要求程序尽可能的高效。示例如下：
 *
/**

 * @param a = "1101"

 * @param b = "1100"

 * @return "11001"

 */

public class 字符串加法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(add(a, b));
    }

    public static String add(String a, String b){

        int maxL = Math.max(a.length(), b.length());
        while (a.length() < maxL) {
            a = "0" + a;
        }
        while (b.length() < maxL) {
            b = "0" + b;
        }

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        String res = "";
        int s = 0;
        for (int i = maxL - 1; i >= 0; i--) {
            int t = (c1[i] - '0') + (c2[i] - '0') + s;
            if (s == 1) {
                s = 0;
            }
            if (t >= 2) {
                s = t / 2;
                t = t % 2;
            }
            res = t + res;
        }
        return s == 1 ? "1" + res : res;
    }

}
