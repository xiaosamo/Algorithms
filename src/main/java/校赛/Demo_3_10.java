package 校赛;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class Demo_3_10 {
    public static void main(String[] args) {
        int[][] a = new int[20][20];
        a[1][1] = 1;
        for (int i = 2; i < 20; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a[i][j]);
                if (j != i) {
                    System.out.print(" ");
                }
            }
            if (i != n) {
                System.out.println();
            }
        }

    }
}
