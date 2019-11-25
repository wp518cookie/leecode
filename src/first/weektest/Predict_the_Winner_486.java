package first.weektest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2017/1/22.
 */
public class Predict_the_Winner_486 {
    private static List<Boolean> list = new ArrayList();

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1,567,1,1,99,100}));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return PredictTheWinner(nums, start + 1, end, nums[start], false) || PredictTheWinner(nums, start, end - 1, nums[end], false);
    }

    public static boolean PredictTheWinner(int[] nums, int start, int end, int value, boolean flag) {
        if (start == end) {
            if (flag) {
                return value + nums[start] >= 0 ? true : false;
            } else {
                return value - nums[start] >= 0 ? true : false;
            }
        }
        else if (start > end) {
            return value >= 0 ? true : false;
        }
        int start1 = start + 1;
        int end1 = end;
        int start2 = start;
        int end2 = end - 1;
        if (flag) {
            return (PredictTheWinner(nums, start1 + 1, end1, value + nums[start1], false) || PredictTheWinner(nums, start1, end1 - 1, value + nums[end1], false)) &&
                    (PredictTheWinner(nums, start2 + 1, end2, value + nums[start2], false) || PredictTheWinner(nums, start2, end2 - 1, value + nums[end2], false));
        } else {
            return (PredictTheWinner(nums, start1 + 1, end1, value - nums[start1], true) || PredictTheWinner(nums, start1, end1 - 1, value - nums[end1], true)) &&
                    (PredictTheWinner(nums, start2 + 1, end2, value - nums[start2], true) || PredictTheWinner(nums, start2, end2 - 1, value - nums[end2], true));
        }
    }
}
