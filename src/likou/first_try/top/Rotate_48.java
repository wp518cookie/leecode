package likou.first_try.top;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-04-09
 * https://leetcode-cn.com/problems/rotate-image/
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 *
 *
 * [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *
 * [[15,13,2,5],
 * [14,4,4,1],
 * [12,8,6,9],
 * [16,7,10,11]]
 */

public class Rotate_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        new Rotate_48().rotate(matrix);
        Arrays.toString(matrix);
    }

    public void rotate(int[][] matrix) {
        recursion(matrix, 0, matrix.length - 1);
    }

    private void recursion(int[][] matrix, int rowStart, int rowEnd) {
        if (rowStart >= rowEnd) {
            return;
        }
        for (int i = 0; i < rowEnd - rowStart; i++) {
            int pre = matrix[rowStart + i][rowEnd];
            matrix[rowStart + i][rowEnd] = matrix[rowStart][rowStart + i];
            int cur = matrix[rowEnd][rowEnd - i];
            matrix[rowEnd][rowEnd - i] = pre;
            pre = cur;
            cur = matrix[rowEnd - i][rowStart];
            matrix[rowEnd - i][rowStart] = pre;
            pre = cur;
            matrix[rowStart][rowStart + i] = pre;
        }
        recursion(matrix, rowStart + 1, rowEnd - 1);
    }
}
