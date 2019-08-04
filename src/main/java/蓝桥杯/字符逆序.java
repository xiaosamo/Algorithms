package 蓝桥杯;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 字符逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(new StringBuilder(s).reverse().toString());
    }
}
