package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 给定一个可能由任意数量的字母和空格组成的字符串序列，序列中每个只包含字母，不包含任何空格的子序列称为一个单词。请输出一个序列中最后一个单词的长度。
 * 例如：carpe diem
 * 4
 */
public class 最后一词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();

        int len = 0;
        for (int i = chars.length - 1; i >= 0 && chars[i] != ' '; i--) {
            ++len;
        }
        System.out.println(len);
    }
}
