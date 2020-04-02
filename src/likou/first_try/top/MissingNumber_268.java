package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-02
 * https://leetcode-cn.com/problems/missing-number/
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 */

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int t = 0;
        for (int i = 0; i <= nums.length; i++) {
            t = t ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            t = t ^ nums[i];
        }
        return t;
    }
}
