package focus.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-04-20
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

public class ClimbStairs_70 {
    // bottom-top
    public int climbStairsFromBottomToTop(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // top-bottom
    public int climbStairsFromTopToBottom(int n) {
        Map<Integer, Integer> memo = new HashMap();
        memo.put(1, 1);
        memo.put(2, 2);
        return recursion(n, memo);
    }

    private int recursion(int n, Map<Integer, Integer> memo) {
        if (n < 1) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = recursion(n - 1, memo) + recursion(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
