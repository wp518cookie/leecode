package likou.card.top_interview_questions_medium.sort_and_search;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-08-31
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv4bbv/
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4};
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, 4)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        int first = -1;
        int last = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                first = findFirst(nums, l, mid, target);
                last = findLast(nums, mid, r, target);
                break;
            }
        }
        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int findLast(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
