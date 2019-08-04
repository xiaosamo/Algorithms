package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/5
 * @description
 */
public class 鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }
        if (K == 1) {
            return 2;
        }
        int t = 0;
        while (N > K+1) {

            ++t;
            N = N >> 1;
        }
        if (N == K) {
            return t + K - 1;
        }
        return t + K;
    }

    public static void main(String[] args) {
        鸡蛋掉落 obj = new 鸡蛋掉落();
        System.out.println(obj.superEggDrop(1, 2));
        System.out.println(obj.superEggDrop(2, 6));
        System.out.println(obj.superEggDrop(3, 14));
    }
}
