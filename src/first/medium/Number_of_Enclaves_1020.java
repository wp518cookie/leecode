package first.medium;

/**
 * @author wuping
 * @date 2019-12-14
 * https://leetcode.com/problems/number-of-enclaves/
 * <p>
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 * <p>
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 * <p>
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 * <p>
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 */

public class Number_of_Enclaves_1020 {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                dfs1(i, 0, A);
            }
            if (A[i][A[0].length - 1] == 1) {
                dfs1(i, A[0].length - 1, A);
            }
        }
        for (int j = 0; j < A[0].length; j++) {
            if (A[0][j] == 1) {
                dfs1(0, j, A);
            }
            if (A[A.length - 1][j] == 1) {
                dfs1(A.length - 1, j, A);
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count += dfs2(i, j, A);
                }
            }
        }
        return count;
    }

    private void dfs1(int i, int j, int[][] A) {
        if (i < 0 || i >= A.length) {
            return;
        }
        if (j < 0 || j >= A[0].length) {
            return;
        }
        if (A[i][j] != 1) {
            return;
        }
        A[i][j] = 0;
        dfs1(i - 1, j, A);
        dfs1(i + 1, j, A);
        dfs1(i, j - 1, A);
        dfs1(i, j + 1, A);
    }

    private int dfs2(int i, int j, int[][] A) {
        if (i < 0 || i >= A.length) {
            return 0;
        }
        if (j < 0 || j >= A[0].length) {
            return 0;
        }
        if (A[i][j] != 1) {
            return 0;
        }
        A[i][j] = -1;
        return 1 + dfs2(i - 1, j, A) + dfs2(i + 1, j, A) + dfs2(i, j - 1, A) + dfs2(i, j + 1, A);
    }
}
