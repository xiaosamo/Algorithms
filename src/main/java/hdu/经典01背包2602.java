package hdu;

import java.util.Arrays;
import java.util.Scanner;

public class 经典01背包2602 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int []v=new int[n+1];
            int []w=new int[n+1];
            int [][]dp=new int[n+1][k+1];
            for (int i = 1; i <= n; i++) v[i] = in.nextInt();
            for (int i = 1; i <= n; i++) w[i] = in.nextInt();

//            for(int i=0;i<=n;i++) dp[1][i]=0;

//            Arrays.fill(dp, 0);
//            dp[0][0]=0;
            dp[1][1]=1;     //当有1件物品，体积为1时有1种情况

            for(int i=1;i<=n;i++){
                for(int j=1;j<=k;j++){
//                    dp[i][j]=(i==1?0:dp[i-1][j]);
                    if(j-v[i]>=0)
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - v[i]] + w[i]);
                    else
                        dp[i][j]=dp[i-1][j];

                }
            }

            System.out.println(dp[n][k]);
        }
    }
}
