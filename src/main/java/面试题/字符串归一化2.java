package 面试题;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 字符串归一化2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                char c = (char) ('a' + i);
                System.out.print(c + "" + counts[i]);
            }
        }
    }
}
