package first.medium;

/**
 * @author wuping
 * @date 2018/12/27
 */

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 7, 1, 4}));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        boolean hold = false;
        int profit = 0;
        int priceBuy = 0;
        int length = prices.length;
        int coolIndex = -2;
        for (int i = 0; i < length; i++) {
            if (!hold) {
                if (i + 1 >= length) {
                    break;
                }
                if (i - coolIndex <= 1) {
                     continue;
                }
                if (prices[i] > prices[i + 1]) {
                    continue;
                } else {
                    if (i + 3 >= length ) {
                        System.out.println("buyIndex: " + i);
                        priceBuy = prices[i];
                        hold = true;
                    } else {
                        if ((prices[i + 3] - prices[i]) >= (prices[i + 3] - prices[i + 2])) {
                            System.out.println("buyIndex: " + i);
                            priceBuy = prices[i];
                            hold = true;
                        } else {
                            continue;
                        }
                    }
                }
            } else {
                if (prices[i] <= priceBuy) {
                    continue;
                } else {
                    if (i + 3 < length) {
                        if ((prices[i + 3] - prices[i + 2]) >= (prices[i + 3] - prices[i])) {
                            System.out.println("sellIndex: " + i);
                            profit += prices[i] - priceBuy;
                            hold = false;
                            coolIndex = i;
                        }
                    } else if (i + 2 == length - 1) {
                        if (prices[i + 2] > prices[i]) {
                            continue;
                        } else {
                            if (prices[i + 1] > prices[i]) {
                                continue;
                            } else {
                                profit += prices[i] - priceBuy;
                                System.out.println("sellIndex: " + i);
                                hold = false;
                                coolIndex = i;
                            }
                        }
                    } else if (i + 1 == length - 1) {
                        if (prices[i + 1] > prices[i]) {
                            continue;
                        } else {
                            profit += prices[i] - priceBuy;
                            System.out.println("sellIndex: " + i);
                            hold = false;
                            coolIndex = i;
                        }
                    } else if (i == length - 1) {
                        System.out.println("sellIndex: " + i);
                        profit += prices[i] - priceBuy;
                        hold = false;
                        coolIndex = i;
                    }
                }
            }
        }
        return profit;
    }
}

