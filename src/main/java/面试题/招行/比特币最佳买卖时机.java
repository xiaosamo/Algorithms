package 面试题.招行;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 */
public class 比特币最佳买卖时机 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] a = new int[split.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(split[i]);
        }

        System.out.println(solve(a));

    }

    private static int solve(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] > a[i]) {
                    ans = Math.max(ans, a[j] - a[i]);
                }
            }
        }
        return ans;
    }
}
