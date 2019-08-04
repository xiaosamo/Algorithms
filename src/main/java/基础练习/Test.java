package 基础练习;

import java.util.Scanner;

public class Test {

    static int maxn=100000;
    public static void main(String[] args) {

//        int m,n,i,j,k,a,b,c;
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int m=in.nextInt();
            if(n==0&&m==0){break;}
            int d[][]=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    d[i][j]=maxn;
                }
            }
//            for(int i=0;i<m;i++){
//                int a=in.nextInt();
//                int b=in.nextInt();
//                int c=in.nextInt();
//                if(c<d[a][b]){
//                    d[a][b]=c;
//                    d[b][a]=c;
//                }
//            }

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
            
//            for(int k=1;k<=n;k++){
//                for(int i=1;i<=n;i++){
//                    for(int j=1;j<=n;j++){
//                        if(d[i][j]>d[i][k]+d[k][j]){
//                            d[i][j]=d[i][k]+d[k][j];
//                        }
//                    }
//                }
//            }
            for(int k=1;k<=n;k++)
                for(int i=1;i<=n;i++)
                    for(int j=1;j<=n;j++)
                        d[i][j]=Math.min(d[i][j],d[i][k]+d[k][j]);

            System.out.println(d[1][n]);
        }

    }

    public static boolean isok(String s)
    {
        //判断回文
        boolean ok = true;
        for (int j = 0; j < s.length() / 2; j++)
        {
            if (s.charAt(j) != s.charAt(s.length() - j - 1))
            {
                ok = false;
                break;
            }

        }
        return ok;
    }
}