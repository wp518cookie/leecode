package first.easy;

/**
 * Created by ping.wu on 2017/2/13.
 */
public class Missing_Number_268 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];
        }
        return result + nums.length;
    }
}
