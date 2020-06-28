package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/8
 * 动态规划：自下而上
 * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 注意，不能写 coins.length && coins[j]<=i，这样只要条件不满足，就返回了，for最后j=0
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        零钱兑换 obj = new 零钱兑换();
        System.out.println(obj.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(obj.coinChange(new int[]{2}, 3));
        System.out.println(obj.coinChange(new int[]{186,419,83,408}, 6249));
        System.out.println(obj.coinChange(new int[]{474,83,404,3}, 264));


    }
}
