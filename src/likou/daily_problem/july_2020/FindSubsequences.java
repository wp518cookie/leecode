package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-25
 * https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 */

public class FindSubsequences {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 7};
        System.out.println(Arrays.toString(new FindSubsequences().findSubsequences(arr).toArray()));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length <= 1) {
            return result;
        }
        recursion(nums, 0, result, new ArrayList());
        return result;
    }

    private void recursion(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        if (current.size() > 1) {
            result.add(new ArrayList(current));
            if (start >= nums.length) {
                return;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (current.size() > 0) {
                if (nums[i] < current.get(current.size() - 1)) {
                    continue;
                }
                current.add(nums[i]);
            } else {
                current.add(nums[i]);
            }
            recursion(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}
