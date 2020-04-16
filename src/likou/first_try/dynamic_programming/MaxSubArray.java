package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-15
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * // todo 分冶法
 */

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result =  Math.max(result, nums[i]);
        }
        return result;
    }
}
