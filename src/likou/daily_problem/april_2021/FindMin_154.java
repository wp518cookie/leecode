package likou.daily_problem.april_2021;

/**
 * @author wuping
 * @date 2021-04-09
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，
 * 并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *  
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *  
 * 进阶：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */

public class FindMin_154 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 0, 1, 1};
        System.out.println(new FindMin_154().findMin(nums));
    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (start + 1 == end) {
            return nums[start] > nums[end] ? nums[end] : nums[start];
        }
        int mid = start + (end - start) / 2;
        int val = nums[mid];
        if (nums[start] < val) {
            if (nums[start] < nums[end]) {
                return findMin(nums, start, mid - 1);
            } else if (nums[start] > nums[end]) {
                return findMin(nums, mid, end);
            } else {
                return Math.min(findMin(nums, start, mid - 1), findMin(nums, mid + 1, end));
            }
        } else if (nums[start] > val) {
                return findMin(nums, start, mid);
        } else {
            return Math.min(findMin(nums, start, mid - 1), findMin(nums, mid + 1, end));
        }
    }
}

