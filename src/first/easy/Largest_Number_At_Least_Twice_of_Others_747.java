package first.easy;

/**
 * Created by Administrator on 2018/1/30.
 */
public class Largest_Number_At_Least_Twice_of_Others_747 {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
    }

    public static int dominantIndex(int[] nums) {
        int largest_num;
        int largets_idx;
        int second_num;
        if (nums.length == 0) {
            return -1;
        }
        largest_num = nums[0];
        largets_idx = 0;
        second_num = 0;
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] > largest_num) {
                second_num = largest_num;
                largest_num = nums[i];
                largets_idx = i;
                continue;
            } else if (nums[i] != largest_num && nums[i] > second_num) {
                second_num = nums[i];
            }
        }
        if (largest_num >= (second_num << 1)) {
            return largets_idx;
        }
        return -1;
    }
}
