package poj;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 斐波那契_矩阵快速幂 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n ==-1) {
                return;
            }
            int p = 10000;

            solve(n, p);
        }
    }

    private static void solve(int n, int p) {
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][] a = {{1, 1}, {1, 0}};
        int ans = pow(a, n - 1, p)[0][0];
        System.out.println(ans % p);

    }

    /**
     * 求矩阵a的n次方
     *
     * @param a
     * @param n
     * @return
     */
    private static int[][] pow(int[][] a, int n, int p) {
        // 单位矩阵
        int[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                res = mul(a, res, p);
            }
            a = mul(a, a, p);
            n >>= 1;
        }
        return res;
    }

    /**
     * 矩阵相乘，模m
     * @param x
     * @param y
     * @param p
     * @return
     */
    private static int[][] mul(int[][] x, int[][] y, int p) {

        // m为行，n为列
        int m = x.length;
        int n = y[0].length;
        int[][] ans = new int[n][m];
        // 矩阵的x的每一行乘矩阵y的每一列
        // 矩阵x的行
        for (int i = 0; i < m; i++) {
            // 矩阵y的列
            for (int j = 0; j < n; j++) {
                // 矩阵x的列
                for (int k = 0; k < x[0].length; k++) {
                    ans[i][j] += (x[i][k] * y[k][j]) % p;
                }
            }
        }
        return ans;
    }
}
