package first.medium;

/**
 * @author wuping
 * @date 2019-12-14
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 */

public class Max_Area_of_Island_695 {
    public static void main(String[] args) {
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid =
                {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(new Max_Area_of_Island_695().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
//        if (grid == null || grid.length <= 1) {
//            return 0;
//        }
//        if (grid[0].length <= 1) {
//            return 0;
//        }
//        for (int i = 0; i < grid.length; i++) {
//            if (grid[i][0] == 1) {
//                dfs1(i, 0, grid);
//            }
//            if (grid[i][grid[0].length - 1] == 1) {
//                dfs1(i, grid[0].length - 1, grid);
//            }
//        }
//        for (int j = 0; j < grid[0].length; j++) {
//            if (grid[0][j] == 1) {
//                dfs1(0, j, grid);
//            }
//            if (grid[grid.length - 1][j] == 1) {
//                dfs1(grid.length - 1, j, grid);
//            }
//        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int result = dfs2(i, j, grid);
                    max = Math.max(result, max);
                }
            }
        }
        return max;
    }

    private void dfs1(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        dfs1(i - 1, j, grid);
        dfs1(i + 1, j, grid);
        dfs1(i, j - 1, grid);
        dfs1(i, j + 1, grid);
    }

    private int dfs2(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length) {
            return 0;
        }
        if (j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = -1;
        return 1 + dfs2(i - 1, j, grid) + dfs2(i + 1, j, grid) + dfs2(i, j - 1, grid) + dfs2(i, j + 1, grid);
    }
}
