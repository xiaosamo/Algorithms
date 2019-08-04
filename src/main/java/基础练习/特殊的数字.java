package 基础练习;

public class 特殊的数字
{
    public static void main(String[] args)
    {
        for (int i = 100; i <= 999; i++)
        {
            if (isok(i))
            {
                System.out.println(i);
            }
        }
    }

    private static boolean isok(int i)
    {
        int t = i;
        int sum=0;
        while (i > 0)
        {
            sum += (int) Math.pow(i % 10, 3);
            i /= 10;
        }


        return sum == t;

    }

}
