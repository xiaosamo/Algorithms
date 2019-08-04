package hdu;

import java.util.Scanner;

public class Main2021
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] m = {100, 50, 10, 5, 2, 1};

        while (in.hasNext())
        {
            int n = in.nextInt();
            if (n == 0)return;

            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                int t = in.nextInt();
                for (int j = 0; j < m.length; j++)
                {
                    sum += t / m[j];
                    t %= m[j];
                }
            }
            System.out.println(sum);


        }



    }
}
