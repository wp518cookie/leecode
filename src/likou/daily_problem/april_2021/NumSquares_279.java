package likou.daily_problem.april_2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wuping
 * @date 2021-06-11
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
 * 其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。 
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 * 1 <= n <= 10^4
 *
 */

public class NumSquares_279 {
    public static void main(String[] args) {
        NumSquares_279 numSquares_279 = new NumSquares_279();
        System.out.println(numSquares_279.numSquares(1));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        List<Integer> mark = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                mark.add(i * i);
            } else {
                break;
            }
        }
        for (int t : mark) {
            for (int i = t; i <= n; i++) {
                dp[i] = Math.min(dp[i - t] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
