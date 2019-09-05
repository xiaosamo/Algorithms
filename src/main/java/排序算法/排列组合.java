package 排序算法;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 */
public class 排列组合 {
    /**
     * 求排列数A(n,m) n > m
     * n! / (n-m)!
     * @param n
     * @param m
     * @return
     */
    public static int A(int n,int m) {
        int b = 1;
        for (int i = 1; i <= n - m; i++) {
            b *= i;
        }
        int a = 1;
        for (int i = 1; i <= n; i++) {
            a *=i;
        }
        return a / b;
    }

    /**
     * 求组合数
     * @param n
     * @param m
     * @return
     */
    public static int C(int n,int m) {
        return A(n, m) / A(m, m); // A(m,m)就是m的阶乘
    }

    public static void main(String[] args) {
        System.out.println(A(3, 2));

        System.out.println(C(3, 2));
        System.out.println(C(3, 1));
        System.out.println(C(3, 0));
    }
}
