package geekbang.tanchao.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-05-21
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, 1};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        threeSum(result, new ArrayList(), 0, nums, 0);
        return result;
    }

    public static void twoSum(List<List<Integer>> result, List<Integer> list, int start, int[] nums, int target) {
        if (nums[start] * 2 > target || nums[nums.length - 1] * 2 < target) {
            return;
        }

    }

    public static void threeSum(List<List<Integer>> result, List<Integer> list, int start, int[] nums, int target) {
        if (nums[start] * 3 > target || nums[nums.length - 1] * 3 < target) {
            return;
        }
        for (int i = start; i < nums.length - 2; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            twoSum(result, list, i + 1, nums, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
