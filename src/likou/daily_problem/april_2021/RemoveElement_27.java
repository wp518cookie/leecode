package likou.daily_problem.april_2021;

/**
 * @author wuping
 * @date 2021-04-19
 * https://leetcode-cn.com/problems/remove-element/
 */

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[idx++] = nums[i];
        }
        return idx;
    }
}
