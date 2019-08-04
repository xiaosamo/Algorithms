package 紫书;

/**
 * 超时
 */

import java.util.Scanner;

public class 小球下落uva679 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int T,D,I,i;
            T = in.nextInt();
            if(T==-1) break;
            for(i=0;i<T;i++) {
                D = in.nextInt(); //最大深度
                I = in.nextInt(); //小球个数
//                Arrays.fill(s,0);
                int s[] = new int[1 << D];     //最大结点个数2^madx-1
                int k=1,n=(1<<D)-1;
                for(int j=0;j<I;j++) {
                    k=1;
                    while(true){
                        s[k]=s[k]==0?1:0;
                        k=s[k]==1?2*k:2*k+1;
                        if(k>n) break;
                    }
                }
                System.out.println(k/2);
            }
        }
    }
}
