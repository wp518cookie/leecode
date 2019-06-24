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
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                list.remove(list.size() -1);
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
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
