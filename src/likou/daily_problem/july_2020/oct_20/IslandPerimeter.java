package likou.daily_problem.july_2020.oct_20;

/**
 * @author wuping
 * @date 2020-10-30
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 *
 */

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                result += count(i, j, row, col, grid);
            }
        }
        return result;
    }

    private int count(int i, int j, int row, int col, int[][] grid) {
        int count = 0;
        if (i == 0) {
            count++;
        }
        if (j == 0) {
            count++;
        }
        if (i == row - 1) {
            count++;
        }
        if (j == col - 1) {
            count++;
        }
        if (i > 0 && grid[i - 1][j] == 0) {
            count++;
        }
        if (j > 0 && grid[i][j - 1] == 0) {
            count++;
        }
        if (i < row - 1 && grid[i + 1][j] == 0) {
            count++;
        }
        if (j < col - 1 && grid[i][j + 1] == 0) {
            count++;
        }
        return count;
    }
}
