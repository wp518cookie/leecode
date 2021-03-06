package likou.company.bytedance.dynamic_greedy;

/**
 * @author wuping
 * @date 2020-07-01
 * https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1042/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class MaxProfit {
    // O(n)解法
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//        int length = prices.length;
//        int[] maxArr = new int[length];
//        int[] minArr = new int[length];
//        for (int i = length - 1; i > 0; i--) {
//            if (i == length - 1) {
//                maxArr[i] = prices[i];
//            } else {
//                maxArr[i] = Math.max(prices[i], maxArr[i + 1]);
//            }
//        }
//        for (int i = 0; i < length - 1; i++) {
//            if (i == 0) {
//                minArr[i] = prices[i];
//            } else {
//                minArr[i] = Math.min(prices[i], minArr[i - 1]);
//            }
//        }
//        int result = 0;
//        for (int i = 0; i < length - 1; i++) {
//            result = Math.max(maxArr[i + 1] - minArr[i], result);
//        }
//        return result;
//    }

//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//        int[] maxArr = new int[prices.length];
//        int[] minArr = new int[prices.length];
//        int max = Integer.MIN_VALUE;
//        for (int i = prices.length - 1; i >= 0; i--) {
//            max = Math.max(prices[i], max);
//            maxArr[i] = max;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            min = Math.min(min, prices[i]);
//            minArr[i] = min;
//        }
//        int result = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            result = Math.max(result, maxArr[i + 1] - minArr[i]);
//        }
//        return result;
//    }
}
