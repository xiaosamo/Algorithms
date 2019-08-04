package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/7
 * @description
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        int t=0;
        while (n > 0) {
            n /= 5;
            t += n;
        }
        return t;
    }

    public static void main(String[] args) {
        阶乘后的零 obj = new 阶乘后的零();
        System.out.println(obj.trailingZeroes(31)); // 7
        System.out.println(obj.trailingZeroes(50)); // 12
        System.out.println(obj.trailingZeroes(20)); // 4
        System.out.println(obj.trailingZeroes(10)); // 1
        System.out.println(obj.trailingZeroes(5));
        System.out.println(obj.trailingZeroes(3));
        System.out.println(obj.trailingZeroes(4));
    }

}
