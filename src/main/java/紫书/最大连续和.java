package 紫书;

import java.util.Scanner;

public class 最大连续和 {
    static int n,l,r;
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            int []a=new int[n+1];
            if(n==0) {
                break;
            }
            for (int i = 1; i <= n; i++) a[i] = in.nextInt();
//            System.out.println(solve(a));
            System.out.println(solve2(a) + " " + a[l] + " " + a[r]);

        }
    }

    //复杂度n^2
    static int solve(int []a){
        int[] s = new int[n+1];
        for (int i = 1; i <= n; i++) {
            s[i]=s[i-1]+a[i];
        }
        int best=0;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                best=Math.max(best,s[j]-s[i-1]);
            }
        }
        return best;

    }

    static int solve2(int []a){
        int[] dp = new int[n + 1];
//        dp[1]=a[1];
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i]=Math.max(dp[i-1]+a[i],a[i]);
            if(dp[i]>max){
                r=i;      //记录终点下标
                max = dp[i];
            }
        }

        //到回去寻找起点下标
        int sum=0;
        for(int i=r;i>=1;i--){
            sum+=a[i];
            if(sum==max){
                l=i;break;
            }
        }
        //若所有K个元素都是负数，则定义其最大和为0，输出整个序列的首尾元素
        if(max<0){
            max=0;
            l=1;
            r=n;
        }
        return max;
    }

    
}
