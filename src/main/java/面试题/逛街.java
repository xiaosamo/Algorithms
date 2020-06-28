package 面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2020/1/15
 * @description
 */
public class 逛街 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        solve(a,n);
    }
    private static void solve(int []a,int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 2; j < n && i + 1 < n; i++) {
                if (a[j] < a[i + 1]) {
                    ++count;
                }
            }

            for (int j = i - 2; j >= 0 && i - 1 >= 0; j--) {
                if (a[j] > a[i - 1]) {
                    ++count;
                }
            }
            System.out.print(count + " ");
        }
    }
}
