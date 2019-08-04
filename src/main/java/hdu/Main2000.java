package hdu;

import java.util.*;

public class Main2000
{


    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);

        while (in.hasNext())
        {

            String s = in.nextLine();
            char[] c = new char[3];
            for (int i = 0; i < s.length(); i++)
            {
                c[i] = s.charAt(i);
            }
            Arrays.sort(c);
            for (int i = 0; i < c.length; i++)
            {
                if (i!=0)
                {
                    System.out.print(" ");
                }
                System.out.print(c[i]);
            }
            System.out.println();

        }
    }

}
