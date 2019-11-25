package first.easy;

/**
 * Created by ping.wu on 2016/12/28.
 */
public class Island_Perimeter_463 {
    public static void main(String[] args) {
        int[][] grid = {{1}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        count++;
                    }
                    if (i == n - 1) {
                        count++;
                    }
                    if (j == 0) {
                        count++;
                    }
                    if (j == m - 1) {
                        count++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        count++;
                    }
                    if (j + 1 <= m - 1 && grid[i][j + 1] == 0) {
                        count++;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        count++;
                    }
                    if (i + 1 <= n - 1 && grid[i + 1][j] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
