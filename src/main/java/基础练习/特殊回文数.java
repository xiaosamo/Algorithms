package 基础练习;

import java.util.Scanner;

public class 特殊回文数
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 10000; i <= 999999; i++)
        {
            if (isok(i,n))
            {
                System.out.println(i);
            }
        }
    }

    private static boolean isok(int i,int n)
    {
        //判断回文
        boolean ok = true;
        String s = String.valueOf(i);
        for (int j = 0; j < s.length() / 2; j++)
        {
            if (s.charAt(j) != s.charAt(s.length() - j - 1))
            {
                ok = false;
                break;
            }
            
        }

        //计算数字和
        int sum=0;
        while (i > 0)
        {
            sum += i % 10;
            i /= 10;

        }

        return sum == n && ok;
    }
}
