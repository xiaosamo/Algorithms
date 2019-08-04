package 蓝桥杯.历届试题;

import java.util.Scanner;

public class 核桃的数量
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        for (int i = 1; i <= 1000000; i++)
        {
            if (i % a == 0 && i % b == 0 && i % c == 0)
            {
                System.out.println(i);
                break;
            }
        }
    }
}
