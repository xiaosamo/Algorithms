package nod51;

import java.util.Arrays;
import java.util.Scanner;

public class 排序 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            Arrays.sort(a);
            for (int i=0;i<n;i++)
                System.out.println(a[i]);
        }
    }
}
