package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-04-16
 * <p>
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * <p>
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * <p>
 * <p>
 * [[0,0,0],[0,1,0],[0,1,0],[1,1,1],[1,1,0]]
 */

public class CountSquares_1277 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 1, 0}, {1, 1, 1}, {1, 1, 0}
        };
        System.out.println(new CountSquares_1277().countSquares(arr));
    }

    public int countSquares(int[][] matrix) {
        int count = 1;
        int result = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int newCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    newCount++;
                }
            }
        }
        result += newCount;
        if (newCount < 3) {
            return result;
        }
        while (count < row && count < col) {
            newCount = 0;
            for (int i = count; i < row; i++) {
                for (int j = count; j < col; j++) {
                    if (matrix[i][j] >= 1 && matrix[i - 1][j] >= count && matrix[i - 1][j - 1] >= count && matrix[i][j - 1] >= count) {
                        matrix[i][j] = count + 1;
                        newCount++;
                    }
                }
            }
            result += newCount;
            if (newCount < 3) {
                return result;
            }
            count++;
        }
        return result;
    }
}
