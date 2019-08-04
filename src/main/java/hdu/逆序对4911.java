package hdu;

import java.util.Scanner;

public class 逆序对4911 {
    static long ans;
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int k=in.nextInt();
            ans=0;
            int []a=new int [n];
            int []t=new int [n];
            for(int i=0;i<n;i++) a[i]=in.nextInt();
            merge(a,0,a.length,t);
//            System.out.println(Arrays.toString(a));
            System.out.println(Math.max(0,ans-k));

        }
    }

    static void merge(int []a,int x,int y,int []t){
        if(y-x>1){
            int m=x+(y-x)/2;
            merge(a,x,m,t);
            merge(a,m,y,t);
            int p=x,q=m,i=x;
            while(p<m||q<y){
                if(q>=y||(p<m&&a[p]<=a[q])) t[i++]=a[p++];
                else {t[i++]=a[q++];ans+=m-p;}
            }
            for(i=x;i<y;i++) a[i]=t[i];
        }
    }
}
