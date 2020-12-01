package likou.daily_problem.july_2020.nov_20;

/**
 * @author wuping
 * @date 2020-12-01
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] defaultResult = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return defaultResult;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    public int[] find(int[] nums, int start, int end, int target) {
        if (start > end) {
            return new int[]{-1, -1};
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) {
            return find(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return find(nums, start, mid - 1, target);
        } else {
            int first = findFirst(nums, start, mid, target);
            int last = findLast(nums, mid, end, target);
            return new int[]{first, last};
        }
    }

    public int findFirst(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] > target) {
            return findFirst(nums, start, mid - 1, target);
        } else if (nums[mid] < target) {
            return findFirst(nums, mid + 1, end, target);
        } else {
            return findFirst(nums, start, mid, target);
        }
    }

    public int findLast(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start + 1) / 2;
        if (nums[mid] > target) {
            return findLast(nums, start, mid - 1, target);
        } else if (nums[mid] < target) {
            return findLast(nums, mid + 1, end, target);
        } else {
            return findLast(nums, mid, end, target);
        }
    }
}
