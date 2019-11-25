package first.dynamic_programming;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-15
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * days = [1,4,6,7,8,20], costs = [2,7,15]
 */

public class Mincost_Tickets_983_dp {
    private int[] CONST_DAY = new int[]{0, 6, 29};

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 8, 9, 20};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(new Mincost_Tickets_983_dp().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        boolean[] fullDays = new boolean[366];
        int[] dp = new int[366];
        for (int day : days) {
            fullDays[day] = true;
        }
        for (int i = 1; i < fullDays.length; i++) {
            if (!fullDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[Math.max(0, i - 1)] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[365];
    }
}
