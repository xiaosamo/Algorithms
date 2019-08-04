package hdu;

import java.util.Scanner;

public class Main1021
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);


        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0)
        {
            String born = in.nextLine();
            String[] borns = born.split("-");

            int y = Integer.parseInt(borns[0]);
            int m = Integer.parseInt(borns[1]);
            int d = Integer.parseInt(borns[2]);

            int leapYear = 0;
            //计算有多少个闰年
            for (int i = y; i <= y + 18; i++)
            {
                if (isYear(i))
                {
                    leapYear++;
                }
            }

            //分两种情况讨论
            //出生那年是是闰年
            if (isYear(y))
            {
                if (m == 2 && d == 29)
                {
                    /*如果他的生日是闰年2月29号，此时输出-1。（因为四年一闰，18 % 4 == 2，
                    所以如果当前是闰年，那18岁指定没戏了）。*/
                    System.out.println(-1);
                    continue;
                }
                if (m > 2)  //如果出生日期在2月后，
                {
                    leapYear--;
                }

            }
            else   //18岁生日是闰年，非闰年出生
            {
                if (isYear(y + 18) && m <= 2 && d < 29)
                {
                    leapYear--;
                }
            }

            System.out.println(365 * 18 + leapYear);


        }




    }

    public static boolean isYear ( int y)
    {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}