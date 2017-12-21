package medium;

/**
 * Created by Administrator on 2017/10/23.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {
    public static void main(String[] args) {
        int[] prices = {1,4,6,2,8,3,10,14};
        System.out.println(maxProfit(prices, 3));
    }
    public static int maxProfit(int[] prices, int fee) {
        int buy = -1;
        int sale = -1;
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buy < 0) {
                buy = prices[i];
                continue;
            } else if (sale < 0 && buy > prices[i]) {
                buy = prices[i];
                continue;
            } else if (sale < 0 && buy > 0 && prices[i] - fee > buy) {
                sale = prices[i];
                continue;
            } else if (sale > 0 && prices[i] > sale) {
                sale = prices[i];
                continue;
            } else if (sale > 0 && prices[i] + fee < sale) {
                System.out.println("buy:"+ buy + "sale:" + sale);
                sum += sale - buy - fee;
                buy = prices[i];
                sale = -1;
            }
        }
        if (sale > 0) {
            System.out.println("buy:"+ buy + "sale:" + sale);
            sum += sale - buy - fee;
        }
        return sum;
    }
}

