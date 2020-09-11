package likou.card.top_interview_questions_medium.dp;

/**
 * @author wuping
 * @date 2020-09-11
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

public class LengthOfLIS {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(new LengthOfLIS().lengthOfLIS(arr));
    }

    /**
     * 执行用时：
     * 14 ms, 在所有 Java 提交中击败了57.96%的用户
     * 内存消耗：
     * 37.7 MB, 在所有 Java 提交中击败了49.27%的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
