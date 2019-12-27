package leetcode;

/**
 * @author yuan
 * @date 2019/12/27
 * @description
 */
public class 整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        if (n == 0) return 0;
        int sumMul = 1;
        int sumAdd = 0;
        while (n > 0) {
            int t = n % 10;
            sumMul *= t;
            sumAdd +=t;
            n /= 10;
        }
        return sumMul - sumAdd;
    }
}
