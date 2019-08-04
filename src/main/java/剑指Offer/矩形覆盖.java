package 剑指Offer;

/**
 * @author yuan
 * @date 2019/7/13
 * @description
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new 矩形覆盖().RectCover(i));
        }
    }
}
