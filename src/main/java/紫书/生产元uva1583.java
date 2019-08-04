package 紫书;

import java.util.Scanner;

public class 生产元uva1583
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int[] ans = new int[200020];
        for (int m = 1; m < 100015; m++)
        {
            int x=m,y=m;
//            System.out.println("x=" + x + ",y=" + y);
            while(x>0) {y+=x%10;x/=10;} //y为各个数字之和+m
//            System.out.println("y=" + y);
            if(ans[y]==0||m<ans[y]) ans[y]=m;
        }
        int T = in.nextInt();
        while (T-- > 0)
        {
            int n = in.nextInt();
            System.out.println(ans[n]);
        }

    }

}
