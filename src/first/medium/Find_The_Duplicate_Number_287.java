package first.medium;

/**
 * Created by ping.wu on 2017/2/10.
 */
public class Find_The_Duplicate_Number_287 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 4, 5};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int[] medium = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (medium[nums[i] - 1] != 0) {
                return nums[i];
            }
            else {
                medium[nums[i] - 1] = -1;
            }
        }
        return -1;
    }
}
