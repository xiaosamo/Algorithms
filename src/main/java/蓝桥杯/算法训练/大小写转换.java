package 蓝桥杯.算法训练;

import java.util.Scanner;

public class 大小写转换
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            {
                char c = (char) (s.charAt(i) - 32);

                System.out.print(c);
            }
            else
            {
                char c = (char) (s.charAt(i) + 32);
                System.out.print(c);
            }
        }
    }
}
