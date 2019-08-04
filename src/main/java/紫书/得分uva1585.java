package 紫书;

import java.util.Scanner;

public class 得分uva1585
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T-- > 0)
        {
            String s = in.nextLine();
            int ans=0;
            int p=0;
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == 'O')
                {
                    ++p;
                    ans+=p;
                }
                else
                {
                    p=0;
                }
            }
            System.out.println(ans);
            
        }

    }

}
