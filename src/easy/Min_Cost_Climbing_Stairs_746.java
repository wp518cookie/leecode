package easy;

/**
 * Created by Administrator on 2017/12/21.
 */
public class Min_Cost_Climbing_Stairs_746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0, 1, 1, 0}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] mc = new int[cost.length + 1];
        mc[0] = cost[0];
        mc[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int costV = (i == cost.length ? 0 : cost[i]);
            mc[i] = Math.min(mc[i - 1], mc[i - 2]) + costV;
        }
        return mc[cost.length];
    }
}
