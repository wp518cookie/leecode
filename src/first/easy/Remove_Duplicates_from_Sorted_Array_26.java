package first.easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Remove_Duplicates_from_Sorted_Array_26 {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == before) {
                count++;
            } else {
                nums[i - count] = nums[i];
                before = nums[i];
            }
        }
        return nums.length - count;
    }
}
