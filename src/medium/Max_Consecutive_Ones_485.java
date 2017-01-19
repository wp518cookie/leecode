package medium;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class Max_Consecutive_Ones_485 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
            } else {
                max = 0;
            }
            if (max > count) {
                count = max;
            }
        }
        return count;
    }
}
