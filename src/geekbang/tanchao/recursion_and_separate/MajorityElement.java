package geekbang.tanchao.recursion_and_separate;

/**
 * @author wuping
 * @date 2019-05-31
 * Input: [3,2,3]
 * Output: 3
 * https://leetcode.com/problems/majority-element/
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 3, 3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (result == val) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    result = val;
                    count++;
                }
            }
        }
        return result;
    }
}
