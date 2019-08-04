package 紫书;

import java.util.Scanner;

public class 蛇形填数
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            int[][] a = new int[n + 1][n + 1];
//            System.out.println(a[0][0]);
//            System.out.println(a[0][0]);
            int x=0,y=n-1;
            a[x][y]=1;
            int tot=1;
            while(tot<n*n)
            {
                while(x+1<n&&a[x+1][y]==0) a[++x][y]=++tot;
                while(y-1>=0&&a[x][y-1]==0) a[x][--y]=++tot;
                while(x-1>=0&&a[x-1][y]==0) a[--x][y]=++tot;
                while(y+1<n&&a[x][y+1]==0) a[x][++y]=++tot;
            }
            for (x = 0; x < n; x++)
            {
                for (y = 0; y < n; y++)
                {
                    System.out.printf("%3d",a[x][y]);
                }
                System.out.println();

            }
        }



    }

}
