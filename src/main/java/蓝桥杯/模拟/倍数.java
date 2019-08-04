package 蓝桥杯.模拟;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class 倍数 {
    public static void main(String[] args) {
//        solve1();
//        solve2();
//        solve3();

        long l = 1032;
        long r = 12302135942453L;

        long d = 234;
        System.out.println(r / d - (l - 1) / d);
        System.out.println(r / d - l / d);
    }

    private static void solve3() {
        long l = 1032;
        long r = 12302135942453L;

        long d = 234;

        long ans = 0;
        while (r >= l) {
            ans += r / d;
            r /= d;
        }

        System.out.println(ans);

    }

    private static void solve2() {
        long r = 12302135942453L;
        long x;
//        for (x = 1; x * 234 <= r; x++) {
//
//        }
        long sum = 0;
        for (x = 234; x <= r; x += 234) {
            ++sum;
        }
//        System.out.println(x);
        System.out.println(sum);
    }

    private static void solve1() {
        long r = 12302135942453L;
        long sum = 0;
        for (long l = 1032; l <= r; l++) {
            if (l % 234 == 0) {
                ++sum;
            }
        }
        System.out.println(sum);
    }
}
