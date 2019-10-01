package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 游戏海报 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println((s.length() + 1) * 26 - s.length());
    }
}
