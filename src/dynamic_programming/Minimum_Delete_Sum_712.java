package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-15
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * <p>
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 */

public class Minimum_Delete_Sum_712 {
    List<List<String>> list = new ArrayList();

    public static void main(String[] args) {
        System.out.println(new Minimum_Delete_Sum_712().minimumDeleteSum("delete", "leet"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    int a = 0;
                    for (int z = 1; z < Math.max(i, j); z++) {
                        a += (i == 0 ? s2.charAt(z - 1) : s1.charAt(z - 1));
                    }
                    dp[i][j] = a;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], s1.charAt(i - 1) + s2.charAt(j - 1) + dp[i - 1][j - 1]);
                }
            }
        }
        for (int[] t : dp) {
            System.out.println(Arrays.toString(t));
        }
        return dp[m][n];
    }
}
