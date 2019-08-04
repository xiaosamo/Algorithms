package 蓝桥杯.算法训练;

import java.util.Scanner;

public class 出现次数最多的整数2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //坑了许多人吧，n<=0时不输出
        if(n<=0) return ;

        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }

        int temp = 1; //temp记录当前出现的次数
        int max = 1;  //max记录最大出现次数
        int ans = a[0];  //ans记录出现次数最多的那个数字

        for (int i = 1; i < n; i++)
        {
            if (a[i - 1] == a[i])
            {
                temp++;
            }
            else
            {
                temp = 1;
            }

            if (temp > max)
            {
                max=temp;
                ans = a[i];

            }
        }
        System.out.println(ans);

    }
}
