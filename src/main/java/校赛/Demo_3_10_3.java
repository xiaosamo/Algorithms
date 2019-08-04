package 校赛;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/10
 * @description 回文数
 */
public class Demo_3_10_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String m = in.next();
            boolean flag = false;
            int i;
            String sum = m;
            for (i = 1; i <= 30; i++) {
                sum = add(n, sum);
                if (ok(sum)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("STEP=" + i);
                System.out.println(sum);
            } else {
                System.out.println("Impossible!");
            }
        }

    }

    private static boolean ok(String  s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0, j = n - 1; i <= n / 2; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }


    private static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private static String add(int n, String m) {
        BigInteger a = new BigInteger(m, n);
        BigInteger b = new BigInteger(rev(m), n);
        return a.add(b).toString(n).toLowerCase();
    }

}
