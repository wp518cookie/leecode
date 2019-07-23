package array;

/**
 * @author wuping
 * @date 2019-07-23
 * https://leetcode.com/problems/find-pivot-index/
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 */

public class Find_Pivot_Index_724 {
    public static void main(String[] args) {
        System.out.println(new Find_Pivot_Index_724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int first = 0;
        int second = sum - nums[0];
        if (first == second) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            first += nums[i - 1];
            second -= nums[i];
            if (first == second) {
                return i;
            }
        }
        return -1;
    }
}
