package likou.company.bytedance.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-25
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1020/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        System.out.println(123);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 3) {
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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int t = -nums[i];
            int half = t / 2;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] > half) {
                    break;
                }
                if (map.containsKey(t - nums[j])) {
                    if (nums[j] == t - nums[j]) {
                        if (nums[i] == nums[j]) {
                            if (map.get(nums[j]) > 2) {
                                List<Integer> temp = new ArrayList();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(t - nums[j]);
                                result.add(temp);
                                continue;
                            }
                        } else {
                            if (map.get(nums[j]) > 1) {
                                List<Integer> temp = new ArrayList();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(t - nums[j]);
                                result.add(temp);
                                continue;
                            }
                        }
                    } else if (nums[j] != t - nums[j]) {
                        List<Integer> temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(t - nums[j]);
                        result.add(temp);
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = length - 1;
            int curr = nums[i];
            while (l < r) {
                int sum = curr + nums[l] + nums[r];
                if (sum == 0) {

                    ret.add(Arrays.asList(curr, nums[l], nums[r]));

                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (sum > 0) {
                    // while (l < r && nums[r] == nums[--r]);
                    --r;
                } else {
                    // while (l < r && nums[l] == nums[++l]);
                    ++l;
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                break;
            }
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            int left = j + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[j] + nums[left] + nums[right];
                if (threeSum == 0) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[left]);
                    innerList.add(nums[j]);
                    innerList.add(nums[right]);
                    list.add(innerList);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (threeSum > 0) {
                    right--;

                } else if (threeSum < 0) {
                    left++;
                }
            }
        }
        return list;
    }
}
