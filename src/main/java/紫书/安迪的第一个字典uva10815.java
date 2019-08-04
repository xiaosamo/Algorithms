package 紫书;

import java.util.*;

public class 安迪的第一个字典uva10815
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        while (in.hasNext())
        {
            String line = in.nextLine().toLowerCase();
            String input = "";
//            if(line.equals("-1")) break;
            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) < 'a' || line.charAt(i) > 'z')
                    input += " ";
                else
                    input +=line.charAt(i);

            }
            String []s=input.split(" ");
            for (int i = 0; i < s.length; i++)
            {
                if (!s[i].equals("")) set.add(s[i]);
            }
        }
        for (String t : set)
            System.out.println(t);

    }
}
