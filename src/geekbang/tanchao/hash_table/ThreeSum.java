package geekbang.tanchao.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-05-21
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        threeSum(result, new ArrayList(), 0, nums, 0);
        return result;
    }

    public static void oneSum(List<List<Integer>> result, List<Integer> list, int start, int[] nums, int target) {
        if (nums[start] > target || nums[nums.length - 1] < target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i--]) {
                continue;
            }
            if (nums[i] == target) {
                list.add(nums[i]);
                result.add(new ArrayList(list));
                list.remove(list.size() - 1);
                return;
            }
        }
    }

    public static void twoSum(List<List<Integer>> result, List<Integer> list, int start, int[] nums, int target) {
        if (nums[start] * 2 > target || nums[nums.length - 1] < target) {
            return;
        }
        for (int i = start; i < nums.length - 1; i++) {
            if (i != start && nums[start] == nums[start--]) {
                continue;
            }
            list.add(nums[i]);
            oneSum(result, list, i + 1, nums, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void threeSum(List<List<Integer>> result, List<Integer> list, int start, int[] nums, int target) {
        if (nums[start] * 3 > target || nums[nums.length - 1] * 3 < target) {
            return;
        }
        for (int i = start; i < nums.length - 2; i++) {
            if (i != start && nums[start] == nums[start--]) {
                continue;
            }
            list.add(nums[i]);
            twoSum(result, list, i + 1, nums, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
