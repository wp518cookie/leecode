package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-09-10
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class CombinationSum2 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        recursion(candidates, 0, 0, target, new ArrayList(), result);
        return result;
    }

    public void recursion(int[] arr, int start, int curVal, int target, List<Integer> current, List<List<Integer>> result) {
        if (curVal == target) {
            result.add(new ArrayList(current));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i - 1] == arr[i]) {
                continue;
            }
            int t = arr[i];
            if (t + curVal > target) {
                return;
            }
            current.add(t);
            recursion(arr, i + 1, curVal + t, target, current, result);
            current.remove(current.size() - 1);
        }
    }
}
