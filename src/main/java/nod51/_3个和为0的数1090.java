package nod51;

import java.util.Arrays;
import java.util.Scanner;

public class _3个和为0的数1090 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int t = in.nextInt();
            int[] a = new int[t];
            for(int i=0;i<t;i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            boolean ok = false;
            for(int i=0;i<t;i++) {
                for(int j=i+1;j<t;j++) {
                    for(int k=j+1;k<t;k++) {
                        if (a[i]+a[j]+a[k]==0) {
                            ok=true;
                            System.out.println(a[i] + " " + a[j] + " " +a[k]);
                        }
                    }
                }
            }
            if (!ok) {
                System.out.println("No Solution");
            }

        }
    }
}
