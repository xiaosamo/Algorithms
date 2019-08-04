package nod51;

import java.util.Arrays;
import java.util.Scanner;

public class 石子归并 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int []a=new int[n+1];
            int []sum=new int[n+1];
            for(int i=1;i<=n;i++) {
                a[i]=in.nextInt();
                sum[i]=sum[i-1]+a[i];
            }

            int [][]dp=new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                for(int s=i;s<=n-i+1;s++){
                    int e=s+i-1;
                    int min = Integer.MAX_VALUE;
                    for(int k=s;k<e;k++){
//                        if(dp[s][k]+dp[k+1][e] + sum[e] - sum[s-1] < min)
//                            min = dp[s][k]+dp[s+1][e]+sum[e]-sum[s-1];
                        min=Math.min(min,dp[s][k]+dp[k+1][e]+sum[e]-sum[s-1]);
                    }
                    dp[s][e]=min;
                }
            }
            System.out.println(dp[1][n]);

//            Arrays.fill(dp, Integer.MAX_VALUE);
            

            

        }
    }
}
