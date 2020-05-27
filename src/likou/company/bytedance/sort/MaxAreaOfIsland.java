package likou.company.bytedance.sort;

/**
 * @author wuping
 * @date 2020-05-27
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1034/
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 *  对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 */

public class MaxAreaOfIsland {
    private int result = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return result;
        }
        int col = grid[0].length;
        if (col == 0) {
            return result;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    result = Math.max(result, 1 + recursion(i - 1, j, row, col, grid)
                            + recursion(i + 1, j, row, col, grid)
                            + recursion(i, j - 1, row, col, grid)
                            + recursion(i, j + 1, row, col, grid));
                }
            }
        }
        return result;
    }

    public int recursion(int i, int j, int row, int col, int[][] grid) {
        if (i < 0 || i >= row) {
            return 0;
        }
        if (j < 0 || j >= col) {
            return 0;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            return 1 + recursion(i - 1, j, row, col, grid)
                    + recursion(i + 1, j, row, col, grid)
                    + recursion(i, j - 1, row, col, grid)
                    + recursion(i, j + 1, row, col, grid);
        }
        return 0;
    }
}
