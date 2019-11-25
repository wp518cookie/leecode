package first.easy;

/**
 * Created by ping.wu on 2016/11/14.
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }
}
