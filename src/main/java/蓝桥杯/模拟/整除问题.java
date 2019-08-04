package 蓝桥杯.模拟;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 整除问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n % m == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
