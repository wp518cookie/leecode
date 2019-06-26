package geekbang.tanchao.dynamic;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-06-26
 */

public class CoinChange {
    private static int min = Integer.MAX_VALUE;
    private static boolean noResult = true;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] coins = {125, 146, 125, 252, 226, 25, 24, 308, 50};
        System.out.println(coinChange(coins, 8402));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coins[0] > amount) {
            return -1;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount == coins[i]) {
                return 1;
            }
            coinChanngeMeta(i, coins, amount - coins[i], 1);
        }
        if (noResult) {
            return -1;
        } else {
            return min;
        }
    }

    public static void coinChanngeMeta(int start, int[] coins, int amount, int count) {
        if (count >= min) {
            return;
        }
        long temp = ((long) (min - count)) * ((long) coins[start]);
        if (temp < amount && (int) temp == temp ) {
            return;
        }
        for (int i = start; i >= 0; i--) {
            if (amount < coins[0]) {
                return;
            }
            int t = coins[i];
            if (amount < t) {
                continue;
            }
            if (amount == t) {
                if (min > count + 1) {
                    noResult = false;
                    min = count + 1;
                }
                return;
            }
            coinChanngeMeta(i, coins, amount - t, count + 1);
        }
    }
}
