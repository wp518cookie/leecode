package likou.first_try.dynamic_programming;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-09-22
 * https://leetcode-cn.com/problems/matrix-block-sum/
 *
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer 
 * ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 * i - K <= r <= i + K, j - K <= c <= j + K 
 * (r, c) 在矩阵内。
 *  
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 */

public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = new MatrixBlockSum().matrixBlockSum(arr, 1);
        System.out.println(result.length);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sumArr = new int[m][n];
        sumArr[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) {
            sumArr[i][0] = mat[i][0] + sumArr[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            sumArr[0][i] = mat[0][i] + sumArr[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + mat[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int startR = i - K < 0 ? 0 : i - K;
                int startC = j - K < 0 ? 0 : j - K;
                int endR = i + K >= m ? m - 1 : i + K;
                int endC = j + K >= n ? n - 1 : j + K;
                ans[i][j] = sumArr[endR][endC];
                if (startR > 0) {
                    ans[i][j] -= sumArr[startR - 1][endC];
                }
                if (startC > 0) {
                    ans[i][j] -= sumArr[endR][startC - 1];
                }
                if (startR > 0 && startC > 0) {
                    ans[i][j] += sumArr[startR - 1][startC - 1];
                }
            }
        }
        return ans;
    }
}
