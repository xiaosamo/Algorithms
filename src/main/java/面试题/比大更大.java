package 面试题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 给定一列非负整数，求这些数连接起来能组成的最大的数。
 * 第一行n>0是一个正整数，表示一共有n个输入。以后每行是一个非负整数，共有n行。
 *
 * n个输入的非负整数连接成的最大的数
 *
 *
 *
输入例子1:
6
9
8
7
65
4
3

输出例子1:
9876543
 */
public class 比大更大 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

//        int[] a = new int[n];
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.contains(o2)) {
                    return 1;
                }
                if (o2.contains(o1)) {
                    return -1;
                }
                return o2.compareTo(o1);

            }

        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            int len = 0;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    ++len;
                }
                sb = sb.delete(1, 2 + len);

            }
        }
        System.out.println(sb.toString());
    }
}
