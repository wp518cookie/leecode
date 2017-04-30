package easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ping.wu on 2017/4/29.
 */
public class Array_Partition_1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {


    }
}
