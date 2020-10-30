package likou.daily_problem.july_2020.sep_20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-09-18
 * https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] mark = new boolean[nums.length];
        return result;
    }

    private void recursion(int start, int[] nums, boolean[] mark, int count,
                           List<Integer> cur, List<List<Integer>> result) {
        if (count == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            cur.add(nums[i]);
            recursion(0, nums, mark, count + 1, cur, result);

        }
    }
}
