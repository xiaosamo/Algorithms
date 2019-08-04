package 紫书;

import java.math.BigInteger;
import java.util.Scanner;

public class Fib的复仇uva12333 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        final int maxn = 100000;
        BigInteger[] f = new BigInteger[maxn];
        f[0] = f[1] = BigInteger.valueOf(1);
        for(int i=2;i<maxn;i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }

        int T = in.nextInt(), i;
        while (T-- > 0) {
            String s = in.next();
            for (i = 0; i < maxn; i++) {
                if (f[i].toString().indexOf(s) == 0) {
                    System.out.println(i);
                    break;
                }
            }
            if (i == maxn) {
                System.out.println(-1);
            }

        }

    }

}
