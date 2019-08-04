package hdu;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1316
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        BigInteger[] f = new BigInteger[1000];
        f[1] = new BigInteger("1");
        f[2] = new BigInteger("2");

        for (int i = 3; i < f.length; i++)
        {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        while (in.hasNext())
        {
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();

            if (a.compareTo(BigInteger.ZERO)==0&&b.compareTo(BigInteger.ZERO)==0) break;

            int sum=0;
            for (int j = 1; j < f.length; j++)
            {
                if (a.compareTo(f[j]) <= 0 && b.compareTo(f[j]) >= 0) sum++;
                if (b.compareTo(f[j]) < 0) break;
            }
            System.out.println(sum);
        }
    }
}
