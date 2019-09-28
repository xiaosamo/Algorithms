package 面试题.端御信息;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/26
 * @description
 *
 * 1、给定字符串S, 要求把S中多于一个的连续空格压缩成一个空格，并将连续的非空格字符串倒序打印出来。
 *
 * 例如：
 * 输入：abc  def efg 输出：cba fed gfe
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] words = s.split("\\s+");
        for (String word : words) {
            System.out.print(reverse(word) + " ");
        }
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
