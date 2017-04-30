package easy;

/**
 * Created by ping.wu on 2017/2/20.
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class Single_Number_III_260 {
    public static int[] singleNumber(int[] nums) {
        int result1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result1 = result1 ^ nums[i];
        }
        int result2 = ~nums[0];
        for (int i = 1; i < nums.length; i++) {
            result2 = result2 ^ (~nums[i]);
        }
        int result3 = nums[0] + result1 + result2;
        for (int i = 1; i < nums.length; i++) {
            result3 = result3 ^ (nums[i] + result1 + result2);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = result1 ^ nums[i];
            if (((~temp) ^ (~nums[i])) == result2 && ((temp + result1 + result2) ^ (nums[i] + result1 + result2)) == result3) {
                return new int[]{nums[i], temp};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int a = 4;
        int b = -4;
        System.out.println(Integer.toBinaryString(-4));
    }
}
