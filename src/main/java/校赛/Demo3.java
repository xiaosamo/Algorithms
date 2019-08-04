package 校赛;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == -1) {
                break;
            }
            int[] a = new int[n];

            int[] b = new int[n];
            int j = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (!set.contains(a[i])) {
                    b[j++] = a[i];
                }
                set.add(a[i]);
            }
            for (int i = 0; i < j; i++) {
                System.out.print(b[i]);
                if (i != j -1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
