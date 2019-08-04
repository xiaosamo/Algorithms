package nod51;

import java.util.Scanner;

public class 背包问题 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] v = new int[n + 1];
            int[] w = new int[n + 1];
            int [][]dp=new int[n+1][k+1];
            for(int i=1;i<=n;i++){
                w[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            dp[1][1]=1;    //只有1个物品，1个体积时有1种放法
            for(int i=1;i<=n;i++){
                for(int j=1;j<=k;j++){
                    if(j-w[i]>=0)
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(dp[n][k]);
        }
    }
}
