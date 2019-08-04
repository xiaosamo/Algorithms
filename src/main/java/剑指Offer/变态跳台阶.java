package 剑指Offer;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/7/13
 * @description
 */
public class 变态跳台阶 {
    /**
     * f(n) = 2 ^(n-1)
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    /**
     * 动态规划
     */
    public int JumpFloorII2(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

}