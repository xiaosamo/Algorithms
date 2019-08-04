package 蓝桥杯.模拟;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class 年龄 {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 10; i <= 100; i++) {
            for (int j = 10; j <= 100; j++) {
                if (isok(i, j)) {
                    System.out.println(i + " " + j);
                    ++num;
                }
            }
        }
        System.out.println(num);
    }

    private static boolean isok(int a, int b) {
        if (a < 10 || b < 10) {
            return false;
        }

        int a1 = a % 10;
        int a2 = a / 10;

        int b1 = b % 10;
        int b2 = b / 10;


        if (a == (b1 + b2) * 2 && b == (a1 + a2) * 3) {
            return true;
        }
        return false;
    }
}
