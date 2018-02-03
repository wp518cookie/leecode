package easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Maximum_Subarray_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
