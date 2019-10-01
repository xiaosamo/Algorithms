package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 找零 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] money = {64, 16, 4, 1};
        int n = in.nextInt();


        int ans = 0;
        int num = 1024 - n;

        for (int i = 0; i < money.length; i++) {
            ans += num / money[i];
            num %= money[i];
        }

        System.out.println(ans);

    }
}
