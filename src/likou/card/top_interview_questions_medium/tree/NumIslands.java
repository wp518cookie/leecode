package likou.card.top_interview_questions_medium.tree;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvtsnm/
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */

public class NumIslands {
    private int count = 0;

    /**
     * 执行用时：
     * 2 ms, 在所有 Java 提交中击败了97.57%的用户
     * 内存消耗：
     * 42.2 MB, 在所有 Java 提交中击败了70.81%的用户
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    recursion(grid, i, j);
                }
            }
        }
        return count;
    }

    public void recursion(char[][] grid, int rIdx, int cIdx) {
        if (rIdx < 0 || rIdx >= grid.length) {
            return;
        }
        if (cIdx < 0 || cIdx >= grid[0].length) {
            return;
        }
        if (grid[rIdx][cIdx] == '0') {
            return;
        }
        grid[rIdx][cIdx] = '0';
        recursion(grid, rIdx - 1, cIdx);
        recursion(grid, rIdx + 1, cIdx);
        recursion(grid, rIdx, cIdx - 1);
        recursion(grid, rIdx, cIdx + 1);
    }
}
