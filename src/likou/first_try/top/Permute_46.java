package likou.first_try.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-04-07
 * https://leetcode-cn.com/problems/permutations/
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
 *
 */

public class Permute_46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new Permute_46().permute(nums);
        for (List<Integer> t : result) {
            System.out.println(Arrays.toString(t.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        recursion(nums, new HashSet(), new ArrayList(), result);
        return result;
    }

    public void recursion(int[] nums, Set<Integer> set, List<Integer> current, List<List<Integer>> result) {
        if (set.size() == nums.length) {
            result.add(new ArrayList(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            current.add(nums[i]);
            recursion(nums, set, current, result);
            set.remove(nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
