package hdu;

import java.util.Scanner;

public class N皇后2553 {
    static int n;
    static int ans=0;
    static int []C=new int[11];
    static int[] f = new int[11];
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            ans=0;
            n=i;
            dfs(0);
            f[i]=ans;
        }
        Scanner in =new Scanner(System.in);
        while ((n=in.nextInt())!=0) {
            System.out.println(f[n]);
        }
    }
    static void dfs(int cur){
        if (cur == n) {
            ++ans;
            return ;
        }
        for(int i=0;i<n;i++) { //在每一列尝试
            boolean ok = true;
            C[cur]=i; //尝试把第cur行的皇后放在第i列
            for (int j = 0; j < cur; j++) { //检查是否和前面的皇后冲突
                if(C[cur]==C[j]||cur-C[cur]==j-C[j]||cur+C[cur]==j+C[j]){
                    ok = false;
                    break;
                }
            }
            if (ok) {          //如果合法，则继续递归
                dfs(cur + 1);
            }
        }
        
    }
}
