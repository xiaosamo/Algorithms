package 面试题;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author yuan
 * @date 2019/9/30
 * @description
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        dfs(chars,0);

        System.out.print("[");
        int i=0;
        for (String st : set) {
            System.out.print(st);
            ++i;
            if (i != set.size() ) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    static TreeSet<String> set = new TreeSet<>();
    private static void dfs(char[] chars, int index) {
        if (index == chars.length) {
            set.add(String.valueOf(chars));
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            dfs(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
