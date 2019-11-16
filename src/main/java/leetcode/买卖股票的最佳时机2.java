package leetcode;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
