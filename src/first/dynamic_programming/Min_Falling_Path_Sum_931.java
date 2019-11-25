package first.dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-12
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 */

public class Min_Falling_Path_Sum_931 {
    private int min = Integer.MAX_VALUE;

    public int minFallingPathSum1(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            minFallingPathSum(A, 0, i, 0);
        }
        return min;
    }

    public void minFallingPathSum(int[][] A, int row, int col, int current) {
        if (row == A.length - 1) {
            min = Math.min(min, current + A[row][col]);
            return;
        }
        if (col - 1 >= 0) {
            minFallingPathSum(A, row + 1, col - 1, current + A[row][col]);
        }
        if (col + 1 < A.length) {
            minFallingPathSum(A, row + 1, col + 1, current + A[row][col]);
        }
        minFallingPathSum(A, row + 1, col, current + A[row][col]);
    }

    public int minFallingPathSum(int[][] A) {
        int length = A.length;
        int[][] states = new int[length][length];
        for (int i = 0; i < length; i++) {
            states[0][i] = A[0][i];
        }
        for (int i = 1; i < length; i++) {
            states[i][0] = Math.min(states[i - 1][0], states[i - 1][1]) + A[i][0];
            for (int j = 1; j < length - 1; j++) {
                states[i][j] = Math.min(Math.min(states[i - 1][j - 1], states[i - 1][j]), states[i - 1][j + 1]) + A[i][j];
            }
            states[i][length - 1] = Math.min(states[i - 1][length - 2], states[i - 1][length - 1]) + A[i][length - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            min = Math.min(states[length - 1][i], min);
        }
        return min;
    }
}
