package likou.daily_problem.july_2020.oct_20;

/**
 * @author wuping
 * @date 2020-10-11
 */

public class CanPartition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 11, 5};
        System.out.println(new CanPartition().canPartition(arr));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return recursion(nums, 0, 0, target);
    }

    public boolean recursion(int[] nums, int start, int cur, int target) {
        for (int i = start; i < nums.length; i++) {
            int t = cur + nums[i];
            if (t > target) {
                continue;
            }
            if (t == target) {
                return true;
            }
            if (recursion(nums, i + 1, t, target)) {
                return true;
            }
        }
        return false;
    }
}
