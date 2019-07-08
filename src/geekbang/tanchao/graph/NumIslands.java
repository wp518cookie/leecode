package geekbang.tanchao.graph;

/**
 * @author wuping
 * @date 2019-07-08
 */

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] marks = new boolean[rowLength][colLength];
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1' && !marks[i][j]) {
                    breadthFirstSearch(i, j, marks, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void breadthFirstSearch(int i, int j, boolean[][] marks, char[][] grid) {
        marks[i][j] = true;
        if (i > 0 && !marks[i - 1][j] && grid[i - 1][j] == '1') {
            breadthFirstSearch(i - 1, j, marks, grid);
        }
        if (i < marks.length - 1 && !marks[i + 1][j] && grid[i + 1][j] == '1') {
            breadthFirstSearch(i + 1, j, marks, grid);
        }
        if (j > 0 && !marks[i][j - 1] && grid[i][j - 1] == '1') {
            breadthFirstSearch(i, j - 1, marks, grid);
        }
        if (j < marks[0].length - 1 && !marks[i][j + 1] && grid[i][j + 1] == '1') {
            breadthFirstSearch(i, j + 1, marks, grid);
        }
    }

    public static void main(String[] args) {

    }
}
