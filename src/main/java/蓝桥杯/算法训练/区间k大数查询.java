package 蓝桥杯.算法训练;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 区间k大数查询
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n,m,l,r,k;
        n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = in.nextInt();
        }
        m = in.nextInt();
        for (int i = 0; i < m; i++)
        {
            l = in.nextInt();
            r = in.nextInt();
            k = in.nextInt();


            ArrayList<Integer> list = new ArrayList<>();
            for (int j = l; j <= r; j++)
            {
                list.add(a[j]);
            }

            Collections.sort(list);    //小到大排序
            System.out.println(list.get(list.size() - k ));
        }
    }
}
