package 面试题.有赞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(a, m));
    }

    private static int solve(int[] a, int m) {
        if (m == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int cur = 0;
        int num = 0;
        do {
            Arrays.sort(a);
            a[0]++;
            a[m - 1]--;
            ++num;
            if (a[m - 1] - a[0] <= min) {
                min = a[m - 1] - a[0];
            }
            if (min == 0 || min == 1) {
                break;
            }
//            cur = getNum(a);
//            if (cur < min) {
//                min = cur;
//            }
//            if (cur == 1 || cur == 0) {
//                break;
//            }
        } while (true);

        return num;
    }

    private static int getNum(int[] a) {
        int l = a.length - 1;

        return 0;
    }
}
