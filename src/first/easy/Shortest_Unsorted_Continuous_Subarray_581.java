package first.easy;

/**
 * @author wuping
 * @date 2019-10-31
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole first.array sorted in ascending order.
 */

public class Shortest_Unsorted_Continuous_Subarray_581 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        System.out.println(new Shortest_Unsorted_Continuous_Subarray_581().findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        boolean flag = false;
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int startIdx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (startIdx == -1) {
                    startIdx = i - 1;
                }
                flag = true;
                break;
            } else if (nums[i] == nums[i - 1]) {
                if (startIdx == -1) {
                    startIdx = i - 1;
                }
            } else {
                startIdx = -1;
            }
        }
        if (startIdx == -1 || !flag) {
            return 0;
        }
        int endIdx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] < nums[i]) {
                if (endIdx == -1) {
                    endIdx = i + 1;
                }
                break;
            } else if (nums[i + 1] == nums[i]) {
                if (endIdx == -1) {
                    endIdx = i + 1;
                }
            } else {
                endIdx = -1;
            }
        }
        return endIdx - startIdx;
    }
}
