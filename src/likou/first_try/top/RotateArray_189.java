package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-14
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        new RotateArray_189().rotate(nums, 2);
    }

    /**
     * 环形法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int count = nums.length;
        int start = 0;
        while (count > 0) {
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count--;
            } while (start != current);
            start++;
        }
    }
}
