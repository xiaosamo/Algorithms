package 紫书;

import java.util.Arrays;
import java.util.Scanner;

public class 素数环uva524 {
    static int []vis=new int[20];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int kase=0;
        while (in.hasNext()) {
            Arrays.fill(vis, 0);
            int n = in.nextInt();
            int[] b = new int[n];
            b[0]=1;
            if (kase!=0) {
                System.out.println();

            }
            System.out.printf("Case %d:\n",++kase);

            dfs(b, n, 1);

//        System.out.println(isprime(2));
//            for (int i = 2; i <= 100; i++) {
//
//                if (isprime(i)) {
//                    System.out.println(i);
//                }
//            }
        }
    }

    static void dfs(int []a,int n,int cur){
        if(cur==n&&isprime(a[0]+a[n-1])){ //边界,别忘了判断第一个数和最后一个数
//            int p=0;
            for(int i=0;i<n;i++) {
                System.out.print(i==0?"":" ");
                System.out.print(a[i]);
            }
            System.out.println();
        }
        for(int i=2;i<=n;i++){ //尝试放每个数i
            if(vis[i]==0&&isprime(a[cur-1]+i)){ //如果i没有使用过，并且和前一个之和为素数
                a[cur]=i;
                vis[i]=1;
                dfs(a,n,cur+1);
                vis[i]=0;

            }
        }
    }

    private static boolean isprime(int n) {
        int m = (int) Math.sqrt(n + 1);
        for(int i=2;i<=m;i++) {
            if(n%i==0) return false;
        }
        return true;

    }
}
