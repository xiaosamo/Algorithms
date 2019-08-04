package 面试题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/4/22
 * @description
 */
public class BigTest2 {
    public static String add(String a,String b) {
        if (a == null || b == null) {
            return null;
        }
        if ("".equals(a)) {
            return b;
        }
        if ("".equals(b)) {
            return a;
        }
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        int i = a.length() - 1, j = b.length() - 1;
        int s = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {

            int t = c1[i] - '0' + c2[j] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            --j;
            --i;

            ans.append(String.valueOf(t));
        }
        while (i >= 0) {
            int t = c1[i] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            ans.append(String.valueOf(t));
            --i;
        }

        while (j >= 0) {
            int t = c2[j] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            ans.append(String.valueOf(t));
            --j;
        }
        if (s > 0) {
            ans.append(s);
        }

        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
//            BigInteger a = in.nextBigInteger();
//            BigInteger b = in.nextBigInteger();
            String a = in.next();
            String b = in.next();
//            System.out.printf("Case %d:\n", i);
//            System.out.printf("%s + %s = %s", a, b, add(a, b));
//            if (i != n) {
//                System.out.println();
//            }
            System.out.println("Case " + i + ":");

            System.out.println(a + " + " + b + " = " + add(a, b));
            if (i != n) {
                System.out.println();
            }
        }
    }
}
