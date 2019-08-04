package 基础练习;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 归并排序 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        int []a=new int[100];
        int []t=new int [a.length];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            a[i]=random.nextInt(100);
        }
        merge_sort(a,0,a.length,t);
        System.out.println(Arrays.toString(a));
        merge_sort2(a,0,a.length,t);
        System.out.println(Arrays.toString(a));

    }

    static void merge_sort(int []a,int x,int y,int []t){
        if(y-x>1){
            int m=x+(y-x)/2; //划分

            //递归求解
            merge_sort(a,x,m,t);
            merge_sort(a,m,y,t);
            
            int p=x,q=m,i=x;
            while(p<m||q<y){
                if(q>=y||(p<m&&a[p]<=a[q])) t[i++]=a[p++];
                else t[i++]=a[q++];
            }
            //从辅助空间复制回a数组
            for(i=x;i<y;i++)
                a[i]=t[i];

        }
    }

    static void merge_sort2(int []a,int x,int y,int []t){
        if(y-x>1){
            int m=x+(y-x)/2;
            merge_sort2(a,x,m,t);
            merge_sort2(a,m,y,t);
            int p=x,q=m,i=x;
            while(p<m||q<y){
                if(q>=y||(p<m&&a[p]<=a[q])) t[i++]=a[p++];
                else t[i++]=a[q++];
            }
            for(i=x;i<y;i++) a[i]=t[i];

        }
    }
}
