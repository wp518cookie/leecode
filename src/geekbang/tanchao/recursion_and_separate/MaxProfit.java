package geekbang.tanchao.recursion_and_separate;

/**
 * @author wuping
 * @date 2019-05-31
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Input: [7,1,5,3,6,4]
 * Output: 7
 */

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        boolean buy = true;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            int price = prices[i];
            if (buy) {
                if (i < length - 1 && price < prices[i + 1]) {
                    buy = false;
                    profit -= price;
                }
            } else {
                if (i == length - 1 || price > prices[i + 1]) {
                    buy = true;
                    profit += price;
                }
            }
        }
        return profit;
    }
}
