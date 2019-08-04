package leetcode;

public class _3的幂 {
    public static boolean isPowerOfThree(int n) {
        int maxNum = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return n > 0 && (maxNum % n == 0) ? true : false;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(27));
//        System.out.println(isPowerOfThree(9));
//        System.out.println(isPowerOfThree(1));
//        System.out.println(isPowerOfThree(8));
//        System.out.println(isPowerOfThree(45));
//        System.out.println(isPowerOfThree(19684));


    }
}
