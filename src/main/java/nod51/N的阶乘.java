package nod51;

import java.math.BigInteger;
import java.util.Scanner;

public class N的阶乘 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            BigInteger ans = BigInteger.ONE;
            for(int i=2;i<=n;i++) {
                ans=ans.multiply(BigInteger.valueOf(i));
            }
            System.out.println(ans);

        }
    }
}
