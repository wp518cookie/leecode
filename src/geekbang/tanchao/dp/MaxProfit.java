package geekbang.tanchao.dp;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-05
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * [7,1,5,3,6,4]
 */

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] profits = new int[prices.length];
        int minPrice = prices[0];
        profits[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(profits[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profits[prices.length - 1];
    }
}
