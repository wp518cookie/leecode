package likou.company.bytedance.dynamic_greedy;

/**
 * @author wuping
 * @date 2020-07-01
 * https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1028/
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxLength = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char t = matrix[i][j];
                if (t == '1') {
                    if (row - i <= maxLength || col - j <= maxLength) {
                        continue;
                    }
                    int length = 1;
                    while (ifSquare(matrix, i, j, row, col, length + 1)) {
                        length++;
                    }
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength * maxLength;
    }

    private boolean ifSquare(char[][] matrix, int startR, int startC, int row, int col, int length) {
        if (startR + length - 1 >= row || startC + length - 1 >= col) {
            return false;
        }
        for (int i = startR; i <= startR + length - 1; i++) {
            if (matrix[i][startC + length - 1] != '1') {
                return false;
            }
        }
        for (int i = startC; i < startC + length - 1; i++) {
            if (matrix[startR + length - 1][i] != '1') {
                return false;
            }
        }
        return true;
    }
}
