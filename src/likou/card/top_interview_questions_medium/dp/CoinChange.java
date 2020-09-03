package likou.card.top_interview_questions_medium.dp;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-09-03
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */

public class CoinChange {
    private int result = -1;

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        recursion(coins, coins.length - 1, amount, 0);
        return result;
    }

    public void recursion(int[] coins, int start, int amount, int current) {
        for (int i = start; i >= 0; i--) {
            int t = coins[i];
            if (t == amount) {
                if (result == -1) {
                    result = current + 1;
                } else {
                    result = Math.min(current + 1, result);
                }
                return;
            } else if (t > amount) {
                continue;
            } else {
                recursion(coins, i, amount - t, current + 1);
            }
        }
    }
}
