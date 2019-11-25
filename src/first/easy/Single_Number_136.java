package first.easy;

/**
 * Created by ping.wu on 2016/11/16.
 */
public class Single_Number_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
