package likou.card.top_interview_questions_medium.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv67o6/
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(new Subsets().subsets(nums).toArray()));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        recursion(0, nums, result, new ArrayList());
        return result;
    }

    private void recursion(int start, int[] nums, List<List<Integer>> result, List<Integer> current) {
        result.add(new ArrayList(current));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            recursion(i + 1, nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}
