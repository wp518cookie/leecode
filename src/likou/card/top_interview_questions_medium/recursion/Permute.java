package likou.card.top_interview_questions_medium.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permute {

    /**
     * 执行用时：
     * 3 ms, 在所有 Java 提交中击败了47.14%的用户
     * 内存消耗：
     * 40 MB, 在所有 Java 提交中击败了49.71%的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] mark = new boolean[nums.length];
        recursion(nums, mark, 0, result, new ArrayList());
        return result;
    }

    public void recursion(int[] nums, boolean[] mark, int count, List<List<Integer>> result, List<Integer> current) {
        if (count == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            current.add(nums[i]);
            recursion(nums, mark, count + 1, result, current);
            mark[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
