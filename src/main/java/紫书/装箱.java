package 紫书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 先排序，每次将最轻的和最重的放一起，如果放不下，则只放一个箱。
 */
public class 装箱 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int p=0,q=n-1,count=0;
            while(p<=q){
                if(a[p]+a[q]<=m){
                    ++p;
                    --q;
                    ++count;
                }else{
                    --q;
                    ++count;
                }
            }
            System.out.println(count);
            if(T>0) System.out.println();

        }

    }
}
