package 剑指Offer;

/**
 * @author yuan
 * @date 2019/1/31
 * @description
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int Fibonacci2(int n) {
        if (n < 2) {
            int[] a = {0, 1};
            return a[n];
        }
        int f1 = 0, f2 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        斐波那契数列 obj = new 斐波那契数列();
        System.out.println(obj.Fibonacci(3));
        System.out.println(obj.Fibonacci2(3));
    }
}
