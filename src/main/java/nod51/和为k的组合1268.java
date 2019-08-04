package nod51;

import java.util.Scanner;

public class 和为k的组合1268 {
    static boolean ok;
    static int n,k;
    static int []a=new int[30];
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            ok = false;
            n = in.nextInt();
            k = in.nextInt();
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            dfs(0,0);
            System.out.println(ok?"Yes":"No");

        }
    }

    static void dfs(int cur,int sum){
        if(sum==k) {
            ok = true;
            return ;
        }
        if(cur==n) return;
        dfs(cur+1,sum);
        dfs(cur+1,sum+a[cur]);
    }
}
