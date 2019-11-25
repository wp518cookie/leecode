package first.binary_search;

/**
 * @author wuping
 * @date 2019-07-25
 * https://leetcode.com/problems/binary-search/
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 */

public class Binary_Search_704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[start] == target ? start : -1;
    }
}
