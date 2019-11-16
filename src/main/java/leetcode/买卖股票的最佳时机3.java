package leetcode;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class 买卖股票的最佳时机3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        int count =2;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max && count > 0) {
                max = prices[i] - min;
                sum+=max;
                --count;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        买卖股票的最佳时机3 obj = new 买卖股票的最佳时机3();

        System.out.println(obj.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
