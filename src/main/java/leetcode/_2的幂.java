package leetcode;

public class _2的幂 {
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(2));
        System.out.println(isPowerOfThree(4));
        System.out.println(isPowerOfThree(3));


    }
}
