package leetcode;

/**
 * @author yuan
 * @date 2018/12/20
 */
public class 丑数 {
    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        丑数 obj = new 丑数();
        System.out.println(obj.isUgly(6));
        System.out.println(obj.isUgly(8));
        System.out.println(obj.isUgly(14));
    }
}
