package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-07-20
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int t = numbers[start] + numbers[end];
            if (t < target) {
                start++;
            } else if (t > target) {
                end--;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[0];
    }
}
