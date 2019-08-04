package 蓝桥杯.模拟;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 */
public class 后缀字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }
        for (String s : str) {
            System.out.println(solve(s, str));
        }
    }

    private static int solve(String s, String[] str) {
        int num = 0;
        for (String st : str) {
            if (st.lastIndexOf(s) >= 0) {
                ++num;
            }
        }
        return num;
    }
}
