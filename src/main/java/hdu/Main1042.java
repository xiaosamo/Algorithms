package hdu;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1042
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            
            BigInteger a = BigInteger.ONE;
            int n = in.nextInt();
            for (int i = 2; i <= n; i++) {
                a = a.multiply(BigInteger.valueOf(i));
            }
            System.out.println(a);
        }

    }

}
