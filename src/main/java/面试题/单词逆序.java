package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/3
 * @description
 */
public class 单词逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]+" ");
        }
    }
}
