package likou.first_try.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-04
 * https://leetcode-cn.com/problems/subsets/
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */

public class Subsets_78 {
    public static void main(String[] args) {
        new Subsets_78().subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        recursion(0, nums, current, result);
        return result;
    }

    public void recursion(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() > 0) {
            List<Integer> temp = new ArrayList<>(current);
            result.add(temp);
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            recursion(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
