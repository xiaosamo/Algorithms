package poj;

import java.util.Scanner;

public class 经典二分1064 {
    static int n,k;
    static double []a;
    public static void main(String []args){
        Scanner in =new Scanner(System.in);

        n=in.nextInt();k=in.nextInt();
        a=new double[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextDouble();
        }
        double l=0,r=1<<30;
        for(int i=0;i<100;i++){   //代替while(r>l) 避免了精度问题    1次循环可以把区间缩小一半，100次可以达到10^(-30)的精度
            double m=l+(r-l)/2.0;
//            System.out.println("l="+l+",r="+r+",m="+m);
            if (isok(m)) l=m;
            else r=m;
        }
        System.out.printf("%.2f\n",Math.floor(r*100)/100);    //保证小数点后向下保留2位（不能四舍五入）,先*100取整，再/100,意为去掉小数点两位之后的数
    }
    static boolean isok(double x){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i]/x;
        }
        return sum>=k;
    }
}
