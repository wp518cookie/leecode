package focus.dp;

/**
 * @author wuping
 * @date 2020-04-20
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

public class MinPathSum_64 {
    // dp[n][n] = Math.min(dp[n - 1][n], dp[n][n - 1]) + grid[n][n]
    public int minPathSumTB(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                memo[i][j] = -1;
            }
        }
        memo[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }
        return recursion(grid, row - 1, col - 1, memo);
    }

    public int minPathSumBT(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    private int recursion(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = Math.min(recursion(grid, i - 1, j, memo), recursion(grid, i, j - 1, memo)) + grid[i][j];
        memo[i][j] = result;
        return result;
    }
}
