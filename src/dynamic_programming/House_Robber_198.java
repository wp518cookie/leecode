package dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-11
 * https://leetcode.com/problems/house-robber/
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class House_Robber_198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(new House_Robber_198().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[i] = nums[i];
            if (i - 2 >= 0) {
                if (i - 3 >= 0) {
                    count[i] = Math.max(count[i - 2], count[i - 3]) + nums[i];
                } else {
                    count[i] += nums[i - 2];
                }
            }
        }
        return Math.max(count[nums.length - 1], count[nums.length - 2]);
    }
}
