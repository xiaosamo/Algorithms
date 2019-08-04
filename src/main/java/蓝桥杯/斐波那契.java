package 蓝桥杯;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 斐波那契 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = in.nextLong();
            long m = in.nextLong();
            long mod = in.nextLong();
            solve(n, m,mod);
        }
    }

    /**
     *
     * @param n
     * @param m
     * @param mod
     */
    private static void solve(long n, long m, long mod) {
//        long sum = 0;
//        long t = f2(m);
//        for (int i = 1; i <= n; i++) {
//            sum = (sum + f2(i));
//        }
//        System.out.println("Sn：" + sum);
//        System.out.println(sum % p);
//        System.out.println("ans :" + sum % t % p);


        long[][] a = {
                {1, 1},
                {1, 0}
        };


        m = pow(a, m - 1, mod)[0][0];
//        System.out.println("m = " + m);
        n = pow(a, n + 1, m)[0][0] - 1;
//        System.out.println("Sn：" + n);

//        System.out.println("n=" + n);
        System.out.println(n % m % mod);



//        if (ans >= m) {
//            ans %= m;
//        }
//        if (ans >= p) {
//            ans %= p;
//        }
//        System.out.println(ans);
//        if (m >= n + 2) {
//            System.out.println(ans % p);
//        } else {
//            System.out.println(ans % pow(a, m - 1, p)[0][0] % p);
//        }

//        // Sn = f(n+2) - 1 ，n是从0开始的
//        n = (pow(a, n + 1, p)[0][0] - 1) % m;
//
//        // f(m)
//        m = (pow(a, m - 1, p)[0][0]) % p;
//
//        System.out.println(n % m % p);

    }


    /**
     * 求矩阵a的n次方
     *
     * @param a
     * @param n
     * @return
     */
    private static long[][] pow(long[][] a, long n,long mod) {
        // 单位矩阵
        long[][] ans = {{1, 0}, {0, 1}};

        while (n > 0) {
            if ((n & 1) == 1) {
                ans = mul(a, ans,mod);
            }
            a = mul(a, a, mod);
            n >>= 1;
        }
        return ans;
    }


    /**
     * 矩阵相乘
     */
    private static long[][] mul(long[][] x, long[][] y, long mod) {
        // m为行，n为列
        int m = x.length;
        int n = y[0].length;
        long[][] ans = new long[n][m];
        // 矩阵的x的每一行乘矩阵y的每一列
        // 矩阵x的行
        for (int i = 0; i < m; i++) {
            // 矩阵y的列
            for (int j = 0; j < n; j++) {
                // 矩阵x的列
                for (int k = 0; k < x[0].length; k++) {
                    ans[i][j] = (ans[i][j] + x[i][k] * y[k][j]) % mod;
                }
            }
        }
        return ans;
    }


    /**
     * 超时
     * @param n
     * @return
     */
    private static long f2(long n) {
        long a = 1, b = 1;
        if (n <= 2) {
            return 1;
        }
        long sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
