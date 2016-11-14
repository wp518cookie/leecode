package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ping.wu on 2016/11/14.
 * Descirption:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSums_1 {
    public static void main(String[] args) {
        int[] testArray = new int[] {2,4,1,3};
        int target = 6;
        int[] result = solution3(testArray, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //O(n^2)
    public int[] solution1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    public int[] solution2(int[] nums, int target) {
        Arrays.sort(nums);
        return null;
    }
    public static int[] solution3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(target - nums[i])) return new int[] { i, map.get(target - nums[i]) };
            map.put(nums[i], i);
        }
        return null;
    }
}
