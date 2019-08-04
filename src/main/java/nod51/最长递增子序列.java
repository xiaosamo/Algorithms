package nod51;

import java.util.Arrays;
import java.util.Scanner;

public class 最长递增子序列
{
    static int n;
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            n = in.nextInt();
            int []a=new int[n+1];
            int []dp=new int[n+1];
            for(int i=1;i<=n;i++) a[i]=in.nextInt();

            System.out.println(solve(a));
            
        }

    }

    //复杂度n^2,超时
    static int solve(int []a){
        int[] dp = new int[a.length];
        Arrays.fill(dp,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[j]<a[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int ans=1;
        for(int i=1;i<=n;i++)
            ans=Math.max(ans,dp[i]);
        return ans;
    }



    
    
}
