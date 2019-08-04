package 紫书;

import java.util.Scanner;

public class 数数字uva1225
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0)
        {
            int[] a = new int[10];
            int n = in.nextInt();
            for (int i = 1; i <= n; i++)
            {
                int x = i;
                while (x > 0)
                {
                    ++a[x % 10];
                    x /= 10;
                }
            }

            for (int i = 0; i < 10; i++)
            {
                if(i!=0) System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();

        }
    }

}
