package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-11
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
