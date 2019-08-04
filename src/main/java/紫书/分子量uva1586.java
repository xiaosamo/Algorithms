package 紫书;

import java.util.Scanner;

public class 分子量uva1586
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        double[] d = {12.01, 1.008, 16.00, 14.01};
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0)
        {
            String s = in.nextLine();
            double ans=0;
            int num=0;
            int k=1;
            for (int i = s.length()-1;i>=0;i--)
            {

                if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                {
                    num += (s.charAt(i) - '0')*k;
                    k*=10;
                    continue;
                }
                switch (s.charAt(i))
                {
                    case 'C':
                        if (num==0) ans += d[0];
                        else ans += num * d[0];
                        break;
                    case 'H':
                        if (num==0) ans += d[1];
                        else ans += num * d[1];
                        break;
                    case 'O':
                        if (num==0) ans += d[2];
                        else ans += num * d[2];
                        break;
                    case 'N':
                        if (num==0) ans += d[3];
                        else ans += num * d[3];
                        break;
                }
                num=0;k=1;

            }
            System.out.printf("%.3f\n",ans);
            
        }

    }

}
