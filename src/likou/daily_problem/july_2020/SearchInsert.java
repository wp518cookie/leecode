package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-07-17
 * https://leetcode-cn.com/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */

public class SearchInsert {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,6};
        System.out.println(new SearchInsert().searchInsert(arr, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        boolean flag = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int t = nums[mid];
            if (t < target) {
                start = mid + 1;
                flag = true;
            } else if (t > target) {
                end = mid - 1;
                flag = false;
            } else {
                return mid;
            }
        }
        return flag ? start : end + 1;
    }
}
