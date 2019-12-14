package first.tree;

/**
 * @author wuping
 * @date 2019-12-12
 * https://leetcode.com/problems/number-of-closed-islands/
 * <p>
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 */

public class Number_of_Closed_Islands_1254 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(new Number_of_Closed_Islands_1254().closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                grid[i][0] = 1;
                dfs1(i, 1, grid);
            }
            if (grid[i][grid[0].length - 1] == 0) {
                grid[i][grid[0].length - 1] = 1;
                dfs1(i, grid[0].length - 2, grid);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 0) {
                grid[0][j] = 1;
                dfs1(1, j, grid);
            }
            if (grid[grid.length - 1][j] == 0) {
                grid[grid.length - 1][j] = 1;
                dfs1(grid.length - 2, j, grid);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs2(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs1(int i, int j, int[][] grid) {
        if (i >= grid.length || i < 0) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            dfs1(i - 1, j, grid);
            dfs1(i + 1, j, grid);
            dfs1(i, j - 1, grid);
            dfs1(i, j + 1, grid);
        }
    }

    private void dfs2(int i, int j, int[][] grid) {
        if (i >= grid.length || i < 0) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = -1;
            dfs2(i - 1, j, grid);
            dfs2(i + 1, j, grid);
            dfs2(i, j - 1, grid);
            dfs2(i, j + 1, grid);
        }
    }
}
