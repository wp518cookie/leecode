package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-27
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int pre = nums[0];
        int count = nums.length;
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                count--;
            } else {
                pre = nums[i];
                nums[idx++] = nums[i];
            }
        }
        return count;
    }
}
