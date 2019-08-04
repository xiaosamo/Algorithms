package 蓝桥杯.算法提高;

import java.util.Scanner;

public class 简单加法
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

//        System.out.println(3%3);
        int sum = 0;
        for (int i = 0; i < 1000; i++)
        {
            if (i % 3 == 0 || i % 5 == 0)
            {
                sum += i;
            }
        }
        System.out.println(sum);

    }
}
