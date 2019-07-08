package geekbang.tanchao.dp;

/**
 * @author wuping
 * @date 2019-07-05
 * [3,3,5,0,0,3,1,4]  6
 */

public class MaxProfit3 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 4, 2, 7};
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[] profit1 = new int[length];
        int[] profit2 = new int[length];
        int minPrice = prices[0];
        int maxPrice = prices[length - 1];
        int result = 0;
        profit1[0] = 0;
        profit2[length - 1] = 0;
        for (int i = 1; i < length; i++) {
            profit1[i] = Math.max(profit1[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
            profit2[length - i - 1] = Math.max(profit2[length - i], maxPrice - prices[length - i - 1]);
            maxPrice = Math.max(maxPrice, prices[length - i - 1]);
        }
        for (int i = 0; i < length; i++) {
            result = Math.max(profit1[i] + profit2[i], result);
        }
        return result;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int oneBuy = Integer.MIN_VALUE;
        int twoBuy = Integer.MIN_VALUE;
        int oneSell = 0;
        int twoSell = 0;
        for(int price : prices){
            oneBuy = Math.max(oneBuy, -price);
            oneSell = Math.max(oneSell, price+oneBuy);
            twoBuy = Math.max(twoBuy, oneSell-price);
            twoSell = Math.max(twoSell, price+twoBuy);
            System.out.println("oneBuy: " + oneBuy + ", oneSell: " + oneSell + ", twoBuy: " + twoBuy + ", twoSell: " + twoSell);
        }
        return twoSell;
    }
}
