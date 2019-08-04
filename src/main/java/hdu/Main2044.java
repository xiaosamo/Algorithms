package hdu;

import java.util.Scanner;

public class Main2044
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);

        long[] a = new long[60];

        a[1]=1;
        a[2]=2;

        for (int i = 3; i < 55; i++)
        {
            a[i] = a[i - 1] + a[i - 2];
        }

        int n = in.nextInt();

        while (n-- > 0)
        {
            int s = in.nextInt();
            int e = in.nextInt();

            System.out.println(a[e - s]);
            
        }

    }
}
