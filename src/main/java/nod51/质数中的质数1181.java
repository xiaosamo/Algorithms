package nod51;

import java.util.Arrays;
import java.util.Scanner;

public class 质数中的质数1181 {
    static int []vis = new int[1000005];
    static int cnt=0;
    static int []ans=new int[1000005];  //记录是第多少个素数
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        solve(1000000);
        for(int i=2;i<=1000000;i++) {
            if(vis[i]==0){
                ans[i]=++cnt;
            }
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = n; ; i++) {
                if(vis[i]==0&&vis[ans[i]]==0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    //筛选素数
    static void solve(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        Arrays.fill(vis, 0);
        for(int i=2;i<=m;i++)
            if(vis[i]==0)
                for(int j=i*i;j<=n;j+=i) {
                    vis[j]=1;
                }
    }
}
