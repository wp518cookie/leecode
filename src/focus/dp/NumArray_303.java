package focus.dp;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-04-21
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */

public class NumArray_303 {
    private int[] dp;

    public static void main(String[] args) {
        System.out.println(new NumArray_303(new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 2));
    }

    public NumArray_303(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(dp));
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
