package 面试题.有赞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class Test1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve2(a, m));
    }

    private static int solve(int[] a, int m) {
        if (m == 1) {
            return 0;
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i = m - 1; i > 0; i--) {
            sum += a[i] - a[i - 1];
        }
//        sum += a[1] - a[0];
        return sum / 2;
    }

    private static int solve2(int[] a, int m) {
        if (m == 1) {
            return 0;
        }
        Arrays.sort(a);
        return (a[m - 1] - a[0]) / 2;
//        sum += a[1] - a[0];
    }

}
