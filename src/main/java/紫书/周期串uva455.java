package 紫书;

import java.util.Scanner;

public class 周期串uva455
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T-- > 0)
        {
            String s = in.nextLine();
            int len = s.length(),j;

            for (int k,i = 1; i <= len; i++)
            {
                if (len % i == 0)
                {
                    for (k = i; k < len / i; k++)
                    {
                        if(!s.substring(0,k).equals(s.substring(k,i+k))) break;
                    }
                    if(k==(len/i))
                    {
                        System.out.println(i);
                        break;
                    }

//                    for (j = i; j < len; j++)
//                        if (s.charAt(j) != s.charAt(j % i)) break;
//                    if(j==len)
//                    {
//                        System.out.println(i);break;
//                    }

                }
            }




        }
    }



}
