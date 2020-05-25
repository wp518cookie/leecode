package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-18
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * <p>
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */

public class MinFallingPathSum_931 {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];
        for (int j = 0; j < col; j++) {
            dp[0][j] = A[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = min(i - 1, j, col, dp) + A[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }
        return result;
    }

    public int min(int i, int j, int col, int[][] dp) {
        int min = dp[i][j];
        if (j > 0) {
            min = Math.min(min, dp[i][j - 1]);
        }
        if (j < col - 1) {
            min = Math.min(min, dp[i][j + 1]);
        }
        return min;
    }
}
