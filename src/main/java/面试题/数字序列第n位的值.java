package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 数字序列第n位的值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int num = n;
        for (int i = 1; i <= n; i++) {
            num -=i;
            if (num <= 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
