package first.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-12-31
 * https://leetcode.com/problems/rotting-oranges/
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */

public class Rotting_Oranges_994 {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int row = grid.length;
        int col = grid[0].length;
        int size = 0;
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    grid[i][j] = -1;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        queue.offer(new Pair(i - 1, j));
                        size++;
                    }
                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        queue.offer(new Pair(i + 1, j));
                        size++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        queue.offer(new Pair(i, j - 1));
                        size++;
                    }
                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        queue.offer(new Pair(i, j + 1));
                        size++;
                    }
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        if (size == 0) {
            return -1;
        }
        int count = 0;
        while (size > 0) {
            count++;
            int newSize = 0;
            while (size-- > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                freshCount--;
                int i = pair.getKey();
                int j = pair.getValue();
                grid[i][j] = -1;
                if (i > 0 && grid[i - 1][j] == 1) {
                    queue.offer(new Pair(i - 1, j));
                    newSize++;
                }
                if (i < row - 1 && grid[i + 1][j] == 1) {
                    queue.offer(new Pair(i + 1, j));
                    newSize++;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    queue.offer(new Pair(i, j - 1));
                    newSize++;
                }
                if (j < col - 1 && grid[i][j + 1] == 1) {
                    queue.offer(new Pair(i, j + 1));
                    newSize++;
                }
            }
            size = newSize;
        }
        return freshCount > 0 ? -1 : count;
    }
}
