package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 比特位计数 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = getBitOf1(i);
        }
        return ans;
    }

    private int getBitOf1(int n) {
        int cnt = 0;
        while (n > 0) {
            ++cnt;
            n = n & (n - 1);
        }
        return cnt;
    }
}
