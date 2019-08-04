package 紫书;

import java.util.Scanner;

public class 小球下落2uva679 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int T,D,I,i;
            T = in.nextInt();
            if(T==-1) break;
            for(i=0;i<T;i++) {
                D = in.nextInt(); //最大深度
                I = in.nextInt(); //小球个数
                int k=1;
                for(int j=0;j<D-1;j++) {
                    if(I%2==1){k=k*2;I=(I+1)/2;}
                    else {k=2*k+1;I/=2;}
                }
                System.out.println(k);
            }
        }
    }
}
