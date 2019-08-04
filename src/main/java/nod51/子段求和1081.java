package nod51;

import java.util.Scanner;

public class 子段求和1081 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n+1];
            for(int i=1;i<=n;i++) {
                a[i] = in.nextInt();
            }
            int t = in.nextInt();
            for(int i=0;i<t;i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                long sum=0;
                for(int j=s;j<s+e;j++) {
                    sum+=a[j];
                }
                System.out.println(sum);
            }
        }
    }
}
