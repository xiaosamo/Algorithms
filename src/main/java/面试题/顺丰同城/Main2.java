package 面试题.顺丰同城;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/26
 * @description
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();



        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        if (n == 0 || n == 1) {
            System.out.println("yes");
            return;
        }
        solve(a, n);
    }

    private static void solve(int[] a, int n) {

        int[] copyA = a.clone();
        if (isAsc(copyA, n)) {
            // 如果有序，直接返回
            System.out.println("yes");
            return;
        }

        // 进行交换
        int i=1,j=n;
        for (int k = 2; k <= n; k++) {
            if (a[k] >= a[k - 1]) {
                ++i;
            } else {
                break;
            }
        }
        for (int k = n; k >1; k--) {
            if (a[k] >= a[k - 1]) {
                --j;
            }else{
                break;
            }
        }

        if (i != 1 && j != n) {
            // 交换
            swap(copyA, i, j);
            if (isAsc(copyA, n)) {
                System.out.println("yes");
                System.out.println("swap " + i + " " + j);
                return;
            }

        }

        // 进行反转
        copyA = a.clone();
        i = 1;j = n;
        for (int k = 2; k <= n; k++) {
            if (a[k] > a[k - 1]) {
                ++i;
            }else{
                break;
            }

        }
        for (int k = n; k >= 1; k--) {
            if (a[k] > a[k - 1]) {
                --j;
            }else{
                break;
            }
        }
        // 反转
        reverse(copyA, i, j);
        if (isAsc(copyA, n)) {
            System.out.println("yes");
            System.out.println("reverse " + i + " " + j);
        }else{
            // 不能排序
            System.out.println("no");
        }

    }
    private static void reverse(int []a,int l,int r) {
        int m = l + (r - l) / 2;
        for (int i = l; i <= m; i++) {
            swap(a,i,r--);
        }
    }
    private static void swap(int []a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 是否升序
    private static boolean isAsc(int []a,int n) {
        for (int i = 2; i <= n; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
