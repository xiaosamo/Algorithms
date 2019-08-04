package 紫书;

import java.util.Scanner;

public class uva401回文词
{
    public static final String[] msg = {"not a palindrome", "a regular palindrome", "a mirrored string", "a mirrored palindrome"};
    public static final String rev = "A   3  HIL JM O   2TUVWXY51SE Z  8 ";

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while (in.hasNext())
        {
            String s = in.nextLine();
            int len = s.length();
            int p = 1, m = 1;
            for (int i = 0; i < (len + 1 / 2); i++)
            {
                if (s.charAt(i) != s.charAt(len - i - 1)) p = 0; //不是回文串
                if (r(s.charAt(i)) != s.charAt(len - i - 1)) m = 0; //不是映像串
            }
            System.out.printf("%s -- is %s.\n\n", s, msg[2 * m + p]);
        }
    }

    private static char r(char c)
    {
        if (c >= '1' && c <= '9') return rev.charAt(c - '0' + 25);     //如果是数字
        return rev.charAt(c - 'A'); //如果是字符
    }
}
