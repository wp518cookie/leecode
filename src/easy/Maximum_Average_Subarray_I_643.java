package easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Maximum_Average_Subarray_I_643 {
    public static double findMaxAverage(int[] nums, int k) {
        int curV = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            curV+= nums[i];
        }
        max = curV;
        for (int i = k; i < nums.length; i++) {
            curV = curV - nums[i - k] + nums[i];
            max = Math.max(curV, max);
        }
        return (double)max / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
