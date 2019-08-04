package leetcode;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class 平方数之和 {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int t = i * i + j * j;
            if (t < c) {
                ++i;
            } else if (t > c) {
                --j;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        平方数之和 obj = new 平方数之和();
        System.out.println(obj.judgeSquareSum(5));
        System.out.println(obj.judgeSquareSum(3));
        System.out.println(obj.judgeSquareSum(4));
        System.out.println(obj.judgeSquareSum(1000000000));


    }
}
