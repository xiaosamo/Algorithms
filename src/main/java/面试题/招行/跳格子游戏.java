package 面试题.招行;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 * 爬楼梯
 */
public class 跳格子游戏 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {

        if (n <= 2) {
            return n;
        }
        return solve(n - 1) + solve(n - 2);
    }



}
