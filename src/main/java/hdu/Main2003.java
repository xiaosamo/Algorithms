package hdu;

import java.util.Scanner;

public class Main2003
{


    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            double d = in.nextDouble();

            System.out.printf("%.2f", Math.abs(d));
            System.out.println();
        }

    }

}
