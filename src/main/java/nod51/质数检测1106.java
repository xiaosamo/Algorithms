package nod51;

import java.util.Scanner;

public class 质数检测1106 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            System.out.println(isprime(n) ? "Yes" : "No");

        }
    }

    static boolean isprime(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        for (int i = 2; i <= m; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
