package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/18
 * 画图即可，如果矩形的上下左右就不重叠
 */
public class 矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];

        if (x2 <= x3 || y1 >= y4 || x1 >= x4 || y2 <= y3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        矩形重叠 obj = new 矩形重叠();
        System.out.println(obj.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
    }
}
