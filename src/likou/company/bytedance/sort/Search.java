package likou.company.bytedance.sort;

/**
 * @author wuping
 * @date 2020-05-27
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1017/
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */

public class Search {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        System.out.println(new Search().search(arr, 3));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return search(0, nums.length - 1, nums, target);
    }

    public int search(int start, int end, int[] nums, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start + 1) >> 1);
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && nums[mid] > target) {
                return search(start, mid - 1, nums, target);
            }
            if (nums[mid] > nums[end]) {
                if (nums[mid] < target || nums[end] >= target) {
                    return search(mid + 1, end, nums, target);
                }
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    return search(mid + 1, end, nums, target);
                }
            }
            return -1;
        } else {
            if (nums[start] <= target || nums[mid] > target) {
                return search(start, mid - 1, nums, target);
            }
            if (nums[mid] < target && nums[end] >= target) {
                return search(mid + 1, end, nums, target);
            }
            return -1;
        }
    }
}
