package 蓝桥杯.算法训练;

import java.util.Scanner;

public class 数字三角形
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] a = new int[2*n][2*n];
        for (int i = 1; i<=n; i++)
            for(int j=1;j<=i;j++)
                a[i][j] = in.nextInt();

        //第1种写法
        for (int i =n;i>=1; i--)
        {
            for(int j=1;j<=i;j++)
            {
                a[i][j] += Math.max(a[i + 1][j], a[i + 1][j + 1]);
            }
        }
        System.out.println(a[1][1]);

        //第2种写法
//        for (int i =1;i<=n; i++)
//        {
//            for(int j=1;j<=i;j++)
//            {
//                a[i][j] += Math.max(a[i - 1][j], a[i - 1][j - 1]);
//            }
//        }
//
//        int ans=0;
//        for (int i = 1; i <=n; i++)
//        {
//            ans = Math.max(ans, a[n][i]);
//        }
//        System.out.println(ans);


    }
}
