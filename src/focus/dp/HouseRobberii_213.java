package focus.dp;

/**
 * @author wuping
 * @date 2020-04-20
 * https://leetcode-cn.com/problems/house-robber-ii/
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */

public class HouseRobberii_213 {
    public static void main(String[] args) {
        int[] t = new int[]{2, 3, 2};  // e: 3  c: 5
        System.out.println(new HouseRobberii_213().robTB(t));
    }

    /**
     * top - bottom
     */
    public int robTB(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robTB(nums, 0, nums.length - 2), robTB(nums, 1, nums.length - 1));
    }

    private int robTB(int[] nums, int start, int end) {
        int pre1 = 0;
        int pre2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return Math.max(pre1, pre2);
    }
}
