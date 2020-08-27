package likou.company.bytedance.dynamic_greedy;

/**
 * @author wuping
 * @date 2020-08-19
 * https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1029/
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] mark = new int[nums.length];
        mark[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mark[i] = Math.max(mark[i - 1] + nums[i], nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < mark.length; i++) {
            ans = Math.max(ans, mark[i]);
        }
        return ans;
    }
}
