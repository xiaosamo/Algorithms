package 紫书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 本题其实等价于找一些数，使得他们的和等于sum/2，猛一看不知道如何下手，其实很简单：从后往前一个个试即可，如果相加后大于sum/2，必然不是这一组的数，由于必然有解，因此这样做最后一定能找到解。
 */

public class 奇怪的股市uva1614 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n==0) break;
            int []a=new int[n];
            int []vis=new int[n];
            Arrays.fill(vis,-1);
            long sum=0,s=0;
            for(int i=0;i<n;i++) {
                a[i]=in.nextInt();
                sum+=a[i];
            }
            if(sum%2!=0){
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
            sum/=2;
            for(int i=n-1;i>=0;i--){
                if(s+a[i]<=sum){
                    s+=a[i];
                    vis[i]=1;
                }
            }
            for(int i=0;i<n;i++){
                System.out.printf("%d%c",vis[i],i==n-1?'\n':' ');
            }
        }
    }
}
