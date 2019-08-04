package poj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 二分平均最大值2976 {
    static int n,k;
    static int []a=new int[1000];
    static int []b=new int[1000];
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            n = in.nextInt();
            k = in.nextInt();
            if(n==0&&k==0) break;
            for(int i=0;i<n;i++) a[i] = in.nextInt();
            for(int i=0;i<n;i++) b[i] = in.nextInt();
            double l=0,r=1<<30;
            for(int i=0;i<100;i++){
                double m =l+(r-l)/2.0;
                if(isok(m)) l=m;
                else r=m;
            }
            System.out.printf("%.0f\n",r*100);
        }
    }
    //平均分=(a[i]/b[i])*100 所以只要平均分a-b*x>=0,说明x成立，继续增加x
    static boolean isok(double x){
         Double []y=new Double[n];
         for(int i=0;i<n;i++){
             y[i]= a[i]-x*b[i];
         }
        Arrays.sort(y, Collections.reverseOrder());    //从大到小排序，优先选大的
        double sum=0;
        for (int i = 0; i < n - k; i++) {

            sum+=y[i];
        }
        return sum>=0;
    }
}
