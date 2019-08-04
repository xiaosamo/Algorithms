package 紫书;

import java.util.Scanner;

public class 分数拆分uva10976 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int ans=0;
            int k = in.nextInt();
            for(int y=k+1;y<=2*k;y++)  if((k*y)%(y-k)==0) ++ans;
            System.out.println(ans);
            for (int y = k+1; y <= 2 * k; y++) { //枚举y  k<y<=2k
                if((k*y)%(y-k)==0){ //x=ky/(y-k) 保证x为正整数
                    int x=k*y/(y-k);
                    System.out.printf("1/%d = 1/%d + 1/%d\n", k, x, y);
                }
            }
        }
    }
}
