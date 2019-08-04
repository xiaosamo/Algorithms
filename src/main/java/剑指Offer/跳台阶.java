package 剑指Offer;

/**
 * @author yuan
 * @date 2019/1/31
 * @description
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        int[] f = new int[target + 2];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= target; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[target];
    }

    public static void main(String[] args) {
        跳台阶 obj = new 跳台阶();
        System.out.println(obj.JumpFloor(3));
    }
}
