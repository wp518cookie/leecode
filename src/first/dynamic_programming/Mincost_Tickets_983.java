package first.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-11
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * days = [1,4,6,7,8,20], costs = [2,7,15]
 */

public class Mincost_Tickets_983 {
    private int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(new Mincost_Tickets_983().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        List<Integer> idx = new ArrayList<>();
        for (int j = 0; j < costs.length; j++) {
            int dayLength = 0;
            if (j == 0) {
                dayLength = 0;
            } else if (j == 1) {
                dayLength = 6;
            } else if (j == 2) {
                dayLength = 29;
            }
            idx.add(j);
            mincostTickets(days, costs, 1, 0, idx, days[0] + dayLength, costs[j]);
            idx.remove(idx.size() - 1);
        }
        return minCost;
    }

    public void mincostTickets(int[] days, int[] costs, int dayIdx, int costIdx, List<Integer> idx, int ticketDay, int cost) {
        if (dayIdx > days.length - 1) {
            System.out.println("idx:" + Arrays.toString(idx.toArray()) + ", cost:" + cost);
            minCost = Math.min(cost, minCost);
            return;
        }
        if (dayIdx == days.length - 1 && ticketDay >= days[dayIdx]) {
            System.out.println("idx:" + Arrays.toString(idx.toArray()) + ", cost:" + cost);
            minCost = Math.min(cost, minCost);
            return;
        }
        if (ticketDay >= days[dayIdx]) {
            mincostTickets(days, costs, dayIdx + 1, 0, idx, ticketDay, cost);
            return;
        }
        if (minCost != Integer.MAX_VALUE && minCost < cost) {
            return;
        }
        for (int j = 0; j < costs.length; j++) {
            int dayLength = 0;
            if (j == 0) {
                dayLength = 0;
            } else if (j == 1) {
                dayLength = 6;
            } else if (j == 2) {
                dayLength = 29;
            }
            idx.add(j);
            mincostTickets(days, costs, dayIdx + 1, j, idx, days[dayIdx] + dayLength, cost + costs[j]);
            idx.remove(idx.size() - 1);
        }
    }
}
