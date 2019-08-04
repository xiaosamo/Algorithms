package 蓝桥杯.算法训练;

import java.util.*;

public class 出现次数最多的整数
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> m = new LinkedHashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //坑了许多人吧，n<=0时不输出
        if(n<=0) return ;

        for (int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            if (!m.containsKey(a))
            {
                m.put(a, 1);
            }
            else
            {
                m.put(a, m.get(a) + 1);
            }

        }

        int maxK=-1;
        int maxV=-1;
        for (Map.Entry<Integer, Integer> map : m.entrySet())
        {
            if (map.getValue() > maxV)
            {
                maxV = map.getValue();
                maxK = map.getKey();

            }
        }
        System.out.println(maxK);
    }
}
