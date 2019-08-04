package other;

import java.util.Arrays;
import java.util.Scanner;

public class 筛选素数 {
    static int []vis=new int[1000000];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        solve2(n);
        for (int i = 2; i <= n; i++) {
            if(vis[i]==0) System.out.println(i);
        }
    }

    private static void solve(int n) {
        Arrays.fill(vis, 0);   //初始化
        for(int i=2;i<=n;i++) {
            for(int j=2*i;j<=n;j+=i)
                vis[j]=1; //vis[j]=1表示不是素数
        }
    }

    private static void solve2(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        Arrays.fill(vis, 0);
        for (int i = 2; i <= m; i++) {
            if (vis[i] == 0) { //对于每个素数
                for(int j=i*i;j<=n;j+=i) {
                    vis[j]=1;
                }
            }
        }
    }
}
