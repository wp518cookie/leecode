package focus.dp;

/**
 * @author wuping
 * @date 2020-04-23
 * https://leetcode-cn.com/problems/integer-break/
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */

public class IntegerBreak_343 {
    int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(new IntegerBreak_343().integerBreak(10));
    }

    public int integerBreak(int n) {
        integerBreakTB(n);
        return result;
    }

    private int integerBreakTB(int n) {
        if (n == 1) {
            return 1;
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            temp = Math.max(i * integerBreakTB(n - i), temp);
            result = Math.max(temp, result);
        }
        return temp;
    }
}
