package dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-16
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * days = [1,4,6,7,8,20], costs = [2,7,15]
 */

public class Mincost_Tickets_Practice_983_1 {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travelDays = new boolean[366];
        for (int day : days) {
            travelDays[day] = true;
        }
        int[] dp = new int[366];
        for (int i = 1; i < travelDays.length; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
            }
            dp[i] = dp[Math.max(0, i - 1)] + costs[0];
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }
        return dp[365];
    }
}
