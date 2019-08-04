package poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2418
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int n = 0;
        Map<String, Double> map = new TreeMap<String, Double>();

        while (in.hasNext())
        {
            String s = in.nextLine();
            n++;
            if (map.containsKey(s))
            {            
                map.put(s, map.get(s) + 1.0);
            }
            else
            {
                map.put(s, 1.0);
            }


//            System.out.println(s);
        }
        for (Map.Entry<String, Double> m : map.entrySet())
        {
            System.out.printf("%s %.4f\n", m.getKey(), (m.getValue() * 100) / n);
        }

    }

}
