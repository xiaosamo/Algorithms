package 校赛;

import java.util.Scanner;

public class 数列求和 {
    public static final int mod = 20180415;
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            long ans=0,t;
            for (int i = 1; i <= n; i++) {
                t=1;
                for(int j=1;j<=5;j++){
                    t=(t*i)%mod;
                }
                ans+=t;
            }
            System.out.println(ans%mod);
        }
    }
}
