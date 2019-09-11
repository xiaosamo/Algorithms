package 面试题.蘑菇街;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/9
 * @description
 */
public class 整数的倒数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.charAt(0) == '-') {
            System.out.println("-" + new StringBuilder(s.substring(1)).reverse());
        } else {
            System.out.println(new StringBuilder(s).reverse());
        }
    }
}
