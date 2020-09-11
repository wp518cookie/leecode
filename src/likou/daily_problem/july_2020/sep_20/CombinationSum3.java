package likou.daily_problem.july_2020.sep_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-09-11
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */

public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CombinationSum3().combinationSum3(3, 7).toArray()));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        if (n > 55) {
            return result;
        }
        recursion(1, k, n, result, new ArrayList());
        return result;
    }

    private void recursion(int start, int k, int target, List<List<Integer>> result, List<Integer> current) {
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList(current));
            return;
        }
        if (start > target) {
            return;
        }
        if (current.size() >= k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                return;
            }
            current.add(i);
            recursion(i + 1, k, target - i, result, current);
            current.remove(current.size() - 1);
        }
    }
}
