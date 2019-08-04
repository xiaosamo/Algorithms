package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/14
 * @description
 * 创建一个CTriangle 类，需要用到第二题中创建的类，即用3点来代表一个三角形，输入三个点的坐标，实现判断此三角形是不是直角三角形，并输出此三角形的周长。
 */
public class 直角三角形 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int[] x = new int[3];
            int[] y = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            solve(x, y);
        }
    }

    private static void solve(int[] x, int[] y) {
        double a = dist(x[0], y[0], x[1], y[1]);
        double b = dist(x[0], y[0], x[2], y[2]);
        double c = dist(x[1], y[1], x[2], y[2]);

        if (equal(a * a + b * b, c * c) || equal(a * a + c * c, b * b) || equal(b * b + c * c, a * a)) {
            // 是直角三角形
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.printf("%.2f\n", a + b + c);
    }

    public static boolean equal(double a, double b) {
        return Math.abs(a - b) < 0.0000000001;
    }

//    public static boolean equl(double a, double b) {
//        return Double.doubleToLongBits(a) == Double.doubleToLongBits(b);
//    }

    private static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }


}
