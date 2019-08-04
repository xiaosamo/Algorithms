package hdu;

import java.util.Scanner;

public class Main2544_2
{
    static int maxn=100005;
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            int n=in.nextInt();int m=in.nextInt();
            if(n==0&&m==0) break;
            int [][]d=new int[n+1][n+1];
            for (int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    d[i][j]=maxn;

            for (int i = 0; i < m; i++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();
                if(w<d[s][e])
                {
                    d[s][e]=d[e][s]=w;
                }
            }

            //注意这里的顺序
            for(int k=1;k<=n;k++)
                for(int i=1;i<=n;i++)
                    for(int j=1;j<=n;j++)
                        d[i][j]=Math.min(d[i][j],d[i][k]+d[k][j]);
            System.out.println(d[1][n]);
        }

    }


}
