package 蓝桥杯.模拟;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class 全排列 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        dfs(0,chars);
    }

    private static void dfs(int index, char[] chars) {
        if (index == chars.length) {
            set.add(chars.toString());
        }
        for (int i = index; i < chars.length; i++) {
            swap(index, i, chars);
            dfs(index + 1, chars);
            swap(index, i, chars);
        }

    }

    private static void swap(int i, int j, char[] chars) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
