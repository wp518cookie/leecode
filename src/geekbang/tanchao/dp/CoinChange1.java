package geekbang.tanchao.dp;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-08
 * https://leetcode.com/problems/coin-change/
 * coins = [1, 2, 5], amount = 11
 */

public class CoinChange1 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        int length = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; i++) {
                if (coins[j] > i) {
                    break;
                }
                if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
