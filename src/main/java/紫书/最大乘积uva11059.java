package 紫书;

import java.util.Scanner;

public class 最大乘积uva11059 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int kase=1;
        while (in.hasNext()) {
            int n = in.nextInt();
            int []a=new int[20];
            for (int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            long ans=-1;
            long t=1;
            for(int i=0;i<n;i++) {        //枚举起点和终点
                for(int j=i;j<n;j++) {
                    t=1;
                    for(int k=i;k<=j;k++){
                        t *= a[k];
                        if(t>ans) ans=t;
                    }
                }
            }
            if(ans<0)ans=0;
            System.out.printf("Case #%d: The maximum product is %d.\n\n",kase,ans);
            ++kase;
        }
    }
}
