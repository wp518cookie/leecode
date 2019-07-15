package dynamic_programming;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-11
 * https://leetcode.com/problems/stone-game/
 * Input: [5,3,4,5]
 * Output: true
 */

public class Stone_Game_877 {
    public static void main(String[] args) {
        int[] stones = new int[]{5, 3, 4, 5};
        System.out.println(new Stone_Game_877().stoneGame(stones));
    }

    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = p[i];
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                System.out.println("i : " + i + ", i + d: " + (i + d));
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
