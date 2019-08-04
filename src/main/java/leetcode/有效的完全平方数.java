package leetcode;

public class 有效的完全平方数 {
    public static boolean isPerfectSquare(int num) {
        // 二分
        // 任意完全平方数都可以表示成连续的奇数和
//        int l = 0, r = num;
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            if (m * m == num) {
//                return true;
//            } else if (m * m > num) {
//                r = m-1;
//            } else {
//                l = m + 1;
//            }
//        }
//        return false;

        int t=1;
        while (num > 0) {
            num -=t;
            t += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }

}
