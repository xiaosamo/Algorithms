package 蓝桥杯.模拟;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class LIS {
    public static final int N = (int)1e5 + 9;
    public static int n = 0;
    public static int[] f = new int[N];
    public static int[] a = new int[N];

    public static int find(int l, int r, int x) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (f[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
        }

    public static int lis() {
        int len = 0;
        for (int i = 0; i < n; i++) {
            /*在这里填写必要的代码*/
            int k = find(0, len, a[i]);
            f[k] = a[i];
            if (k == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
//        n = cin.nextInt();
        n = 7;
        int[] b = {2, 55, 33, 44, 11, 77, 66};
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
        System.out.println(lis());
    }
}
