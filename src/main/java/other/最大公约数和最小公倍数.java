package other;

import java.util.Scanner;

public class 最大公约数和最小公倍数
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println(lcm(a, b)); //37
        }

    }

    /**
     * 求最大公约数
     */
    public static int gcd(int m, int n)
    {
        //保证max>min
        int max = m > n ? m : n;
        int min = m < n ? m : n;
        return max % min == 0 ? min : gcd(min, max % min);
    }

    /**
     * 求最下公倍数
     */
    public static int lcm(int m, int n)
    {
        return m * n / gcd(m, n);
    }


}
