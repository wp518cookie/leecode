package geekbang.tanchao.dp;

/**
 * @author wuping
 * @date 2019-07-05
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 10,9,2,5,3,7,101,18  4
 * 2,3,7,101
 */

public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
