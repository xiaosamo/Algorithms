package leetcode;

/**
 * 需要找出给定数组中两个数字之间的最大差值（即，最大利润）。此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
 * 形式上，对于每组 ii 和 jj（其中 j > ij>i）我们需要找出 \max(prices[j] - prices[i])max(prices[j]−prices[i])。
 * @author yuan
 * @date 2019/1/25
 */
public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }

        return maxPrice;
    }
    public int maxProfit3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] -min;
            }
        }
        return max;
    }






    public static void main(String[] args) {
        买卖股票的最佳时机 obj = new 买卖股票的最佳时机();
        int[] a = {7, 1, 5, 3, 6, 4};
//        int[] b = {};
        System.out.println(obj.maxProfit(a));
        System.out.println(obj.maxProfit3(new int[]{1, 2}));
    }
}
