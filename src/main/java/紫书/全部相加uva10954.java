package 紫书;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 全部相加uva10954 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n==0)break;
            int ans=0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=0;i<n;i++) {
                int t = in.nextInt();
                queue.add(t);
            }
            while(queue.size()>1){
                int a=queue.poll();
                int b=queue.poll();
                queue.add(a+b);
                ans+=a+b;
            }
            System.out.println(ans);
//            while(!queue.isEmpty()){
//                System.out.println(queue.poll());
//            }
        }
    }
}
