package hdu;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 并查集 {
    static int []num;
    static int[] par;
    static int n;
    static int MAX = 10000005;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            num = new int[MAX];
            par = new int[MAX];
            init();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                unit(a, b);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, num[i]);
            }
            System.out.println(ans);
        }
    }

    private static void init() {
        for (int i = 0; i < MAX; i++) {
            par[i] = i;
            //集合个数初始化为1
            num[i] = 1;
        }
    }
    private static int find(int a) {
        return par[a] == a ? a : find(par[a]);
    }

    private static void unit(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 != p2) {
            par[p2] = p1;
            //合并集合中的个数
            num[p1] += num[p2];
        }
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }


}
