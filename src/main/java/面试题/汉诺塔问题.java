package 面试题;

/**
 * @author yuan
 * @date 2019/10/16
 * @description
 * 有N个盘，A、B、C3根杆子，使得从A移动到C
 */
public class 汉诺塔问题 {

    public static void main(String[] args) {
        move(64, "A", "B", "C");
    }

    private static void move(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println("move " + n + ", " + A + " -> " + C);
            return;
        }
        move(n - 1, A, C, B); // 把n-1个盘，借助C，从A移动到B
        System.out.println("move " + n + ", " + A + " -> " + C);// 把第n个盘，从A移动C
        move(n - 1, B, A, C); // 把n-1个盘，借助A，从B移动到C
    }
}
