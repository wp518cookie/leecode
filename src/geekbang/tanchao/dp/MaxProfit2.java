package geekbang.tanchao.dp;

/**
 * @author wuping
 * @date 2019-07-05
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * [7,1,5,3,6,4]    7
 */

public class MaxProfit2 {
    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
