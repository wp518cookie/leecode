package easy;

import java.util.Arrays;

/**
 * Created by ping.wu on 2017/4/17.
 */
public class Next_Greater_Element_I_496 {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        for (int i = 0; i<findNums.length; i++) {
            int temp1 = findNums[i];
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (temp1 == nums[j]) {
                    flag = true;
                }
                if (flag && nums[j] > temp1) {
                    result[i] = nums[j];
                    break;
                }
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
