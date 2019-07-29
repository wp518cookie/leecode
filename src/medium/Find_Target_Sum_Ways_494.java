package medium;

/**
 * @author wuping
 * @date 2019-07-27
 * https://leetcode.com/problems/target-sum/
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 */

public class Find_Target_Sum_Ways_494 {
    public static void main(String[] args) {
        System.out.println(new Find_Target_Sum_Ways_494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            if (nums[0] == S || nums[0] == -S) {
                return 1;
            }
            return 0;
        }
        findTargetSumWays(nums, 1, S + nums[0]);
        findTargetSumWays(nums, 1, S - nums[0]);
        return count;
    }

    public void findTargetSumWays(int[] nums, int start, int target) {
        if (start == nums.length - 1) {
            if (nums[start] == target) {
                count++;
            }
            if (nums[start] == -target) {
                count++;
            }
            return;
        }
        findTargetSumWays(nums, start + 1, target + nums[start]);
        findTargetSumWays(nums, start + 1, target - nums[start]);
    }
}
