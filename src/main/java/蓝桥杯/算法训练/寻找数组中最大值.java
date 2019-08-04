package 蓝桥杯.算法训练;

import java.util.Scanner;

public class 寻找数组中最大值
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if (n<=0) return;
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }

        int max=0;
        int maxNum=a[0];
        for (int i = 1; i < n; i++)
        {
            if (a[i] > maxNum)
            {
                maxNum = a[i];
                max=i;
            }
        }

        System.out.println(maxNum + " " + max);
    }
}
