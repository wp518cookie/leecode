package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-01
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 最优子结构
 * 无后效性
 * 重复子问题
 */

public class MaxProfit_122 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit_122().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
