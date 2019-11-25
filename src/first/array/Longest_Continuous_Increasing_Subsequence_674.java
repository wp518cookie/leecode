package first.array;

/**
 * @author wuping
 * @date 2019-07-23
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * Input: [1,3,5,4,7]
 * Output: 3
 */

public class Longest_Continuous_Increasing_Subsequence_674 {
    public static void main(String[] args) {
        System.out.println(new Longest_Continuous_Increasing_Subsequence_674().findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            pre = nums[i];
        }
        return Math.max(maxCount, count);
    }
}
