package easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buyIndex = 0;
        int saleIndex = 1;
        int maxProfit = 0;
        while(saleIndex < prices.length) {
            if (prices[buyIndex] > prices[saleIndex]) {
                buyIndex = saleIndex;
                saleIndex++;
            } else {
                if (prices[saleIndex] - prices[buyIndex] > maxProfit) {
                    maxProfit = prices[saleIndex] - prices[buyIndex];
                }
                saleIndex++;
            }
        }
        return maxProfit;
    }
}
