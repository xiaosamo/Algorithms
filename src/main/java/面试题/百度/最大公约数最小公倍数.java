package 面试题.百度;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/24
 * @description
 */
public class 最大公约数最小公倍数 {
    public static void main(String[] args) {

//        System.out.println(gcd(2, 10));
//        System.out.println(gcd(10, 100));
//        System.out.println(gcd(100, 10));


//        System.out.println(gcd(5,6));
//        System.out.println(gcd(6, 5));
//        System.out.println(gcd( 2,10));
//        System.out.println(lcm(5, 6));

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = 1, r = n;
        int max = 0;
        int last = -1;
        while (l <= r) {
            if (last == l) {
                ++l;
            }
            if (l > n) {
                break;
            }
            last = l;
            max = Math.max(max, lcm(l, r) - gcd(l, r));
            l = l + (r - l) / 2;

//            System.out.println(l + " " + r);
        }
        System.out.println(max);
//        System.out.println(lcm(n, n - 1) - gcd(n, n - 1));
//        System.out.println(n * (n - 1) - 1);

    }

    /**
     * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    private static int lcm(int a,int b){
        return a * b / gcd(a, b);
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a,int b){
        if (a > b) {
            int t=a;
            a = b;
            b = t;
        }

        if (a == 1 || b == 1) {
            return 1;
        }

        if (a % b == 0) {
            return a;
        }
        return gcd(a, b / a);
    }

}
