package 蓝桥杯.模拟;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 */
public class 国王的烦恼 {
    static int []num;
    static int[] par;
    static int n, m;

    static int MAX = 10005;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        num = new int[MAX];
        par = new int[MAX];

        init();

        int a, b, t;
        int max = 0;

        int[][] aa = new int[m][3];

        for (int i = 0; i < m; i++) {
            a = in.nextInt();
            b = in.nextInt();
            t = in.nextInt();

            aa[i][0] = a;
            aa[i][1] = b;
            aa[i][2] = t;

            max = Math.max(max, t);
            unit(a, b);
        }

        Arrays.sort(aa, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int ans = 0;
        for (int i = 0, d = 1; d <= max; d++, i++) {

            if (i >= m) {
                break;
            }

            aa[i][2]-=d;

            a = aa[i][0];
            b = aa[i][1];
            t = aa[i][2];


//            for (int j = 0; j < m; j++) {
//                aa[j][2]--;
//            }






            if (t <= 0) {
                --num[a];
                --num[b];
            }

            if (num[1] < n) {
                ++ans;
            }
        }
        System.out.println(ans);

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

    private static void del(int a,int b) {

    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }

}
