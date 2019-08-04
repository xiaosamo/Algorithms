package 蓝桥杯.历届试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 分巧克力 {
    static int n,k;
    static int [][]a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        a = new int[n][2];

        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();

            max = Math.max(max, Math.max(a[i][0], a[i][1]));
        }

        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isok(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(Math.min(l,r));
    }

    private static boolean isok(int x) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (a[i][0] / x) * (a[i][1] / x);
        }
        return sum >= k;
    }
}
