package first.dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-11
 * https://leetcode.com/problems/range-sum-query-immutable/
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */

public class Range_Sum_Query_303 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        System.out.println(new Range_Sum_Query_303(arr));
    }

    private int[] mark;

    public Range_Sum_Query_303(int[] nums) {
        if (nums.length == 0) {
            mark = new int[0];
        } else {
            int length = nums.length;
            mark = new int[length];
            mark[0] = nums[0];
            for (int i = 1; i < length; i++) {
                mark[i] = mark[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return mark[j];
        } else {
            return mark[j] - mark[i - 1];
        }
    }
}
