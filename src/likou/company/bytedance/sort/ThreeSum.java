package likou.company.bytedance.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-25
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1020/
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        System.out.println(123);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] * 3 > 0 || nums[nums.length - 1] * 3 < 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        recursion(0, 0, 0, nums, map, new ArrayList(), result);
        return result;
    }

    public void recursion(int start, int sum, int count, int[] nums, Map<Integer, Integer> map, List<Integer> current, List<List<Integer>> result) {
        if (count == 2) {
            int rest = 0 - sum;
            if (current.get(current.size() - 1) <= rest && map.containsKey(rest) && map.get(rest) > 0) {
                List<Integer> temp = new ArrayList<>(current);
                temp.add(rest);
                result.add(temp);
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            int rest = 0 - sum;
            int t = nums[i];
            if (t * (3 - count) > rest || nums[nums.length - 1] * (3 - count) < rest) {
                return;
            }
            current.add(t);
            map.put(t, map.get(t) - 1);
            recursion(i + 1, sum + t, count + 1, nums, map, current, result);
            current.remove(current.size() - 1);
            map.put(t, map.get(t) + 1);
        }
    }
}
