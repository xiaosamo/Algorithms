package 面试题;

import java.util.Scanner;


/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class 今年的第几天 {
    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y =in.nextInt();
        int m =in.nextInt();
        int d = in.nextInt();
        System.out.println(solve(y, m, d));
    }

    private static int solve(int y, int m, int d) {
        int sum = d;
        for (int i = 1; i < m; i++) {
            sum += month[i];
        }
        if (isLeap(y) && m > 2) {
            ++sum;
        }
        return sum;
    }

    static boolean isLeap(int y){
        return (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0));
    }
}
