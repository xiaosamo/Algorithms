package nod51;

import java.util.Collections;
import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
//        while(in.hasNext())
        {
            String a = in.next();
            String b = in.next();
            a=' '+a;
            b=' '+b;
            int n=a.length()-1,m=b.length()-1;
            int[][] dp = new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(a.charAt(i)==b.charAt(j))
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
//            System.out.println(n+" "+m);

            //倒推输出
            int i=n,j=m;
            String ans="";
            while(i>0&&j>0){
                if (a.charAt(i) == b.charAt(j)) {
                    ans+=a.charAt(i);
                    i--;
                    j--;
                } else if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }

            }
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(dp[n][m]);
            System.out.println(new StringBuilder(ans).reverse().toString());
            
        }


    }

}
