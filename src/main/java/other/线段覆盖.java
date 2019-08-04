package other;

import java.util.Arrays;
import java.util.Scanner;

public class 线段覆盖
{
    /**
     * 自定义排序
     */
    static class P implements Comparable<P>
    {
        int a,b;
        @Override
        public int compareTo(P t)
        {
            return b-t.b; //b按升序
        }
    }
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        P[] p = new P[2];
        for(int i=0;i<p.length;i++)
        {
            p[i] = new P();
            p[i].a = in.nextInt();
            p[i].b = in.nextInt();
        }
//        Arrays.sort(p,0,2);
        Arrays.sort(p);
        for (int i = 0; i < p.length; i++)
        {
            System.out.println(p[i].a + " " + p[i].b);
        }

    }

}
