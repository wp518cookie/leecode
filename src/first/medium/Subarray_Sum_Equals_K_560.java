package first.medium;

/**
 * Created by ping.wu on 2017/5/21.
 */
public class Subarray_Sum_Equals_K_560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int sum = nums[i];
            while (j < nums.length) {
                if (sum == k) {
                    count++;
                    j++;
                    if (j < nums.length) {
                        sum += nums[j];
                    } else {
                        break;
                    }
                } else {
                    j++;
                    if (j < nums.length) {
                        sum += nums[j];
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
