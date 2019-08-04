package 基础练习;

public class 回文数
{
    public static void main(String[] args)
    {
        for (int i = 1000; i <= 9999; i++)
        {
            if (isok(i))
            {
                System.out.println(i);
            }
        }
    }

    private static boolean isok(int n)
    {
        boolean ok=true;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                ok = false;
                break;
            }
        }
        return ok;
    }
}
