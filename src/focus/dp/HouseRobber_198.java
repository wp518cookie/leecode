package focus.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-04-20
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

public class HouseRobber_198 {
    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 3, 1};
        System.out.println(new HouseRobber_198().robTB(t));
    }

    // top - bottom
    public int robTB(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, nums[0]);
        map.put(1, Math.max(nums[0], nums[1]));
        return Math.max(recursion(nums.length - 1, nums, map), recursion(nums.length - 2, nums, map));
    }

    private int recursion(int idx, int[] nums, Map<Integer, Integer> memo) {
        if (idx < 0) {
            return 0;
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        int result = Math.max(recursion(idx - 2, nums, memo), recursion(idx - 3, nums, memo)) + nums[idx];
        memo.put(idx, result);
        return result;
    }

    // bottom-top
    public int robBT(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }

    public int robBT1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre1 = 0;
        int pre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return Math.max(pre1, pre2);
    }
}
