package nod51;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _4个和为0的数1267 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            boolean ok = false;
            for(int i=0;i<n;i++) {
                for (int j = i + 1; j < n; j++) {
                    long sum=-a[i]-a[j];
                    int l=j+1,r=n-1;
                    while(l<r){
                        if(a[l]+a[r]==sum){
                            ok=true;
                            break;
                        } else if (a[l] + a[r] > sum) {
                            --r;
                        } else {
                            ++l;
                        }
                    }
                }
            }
            System.out.println(ok ? "Yes" : "No");

        }
    }
}
