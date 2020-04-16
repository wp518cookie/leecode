package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-15
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *  输入：n = 5
 *  输出：13
 * 提示:
 * n范围在[1, 1000000]之间
 */

public class WaysToStep {
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            if (dp[i] > 1000000007) {
                dp[i] = dp[i] % 1000000007;
            }
        }
        return (int) (dp[n - 1] % 1000000007);
    }
}
