package first.medium;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/18.
 */
public class Partition_to_K_Equal_Sum_Subsets_698 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 5, 6};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        return true;
    }
}
