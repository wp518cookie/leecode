package likou.contest.contest_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-02
 * https://leetcode-cn.com/contest/weekly-contest-200/problems/minimum-swaps-to-arrange-a-binary-grid/
 */

public class MinSwaps {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 0, 0}};
        System.out.println(new MinSwaps().minSwaps(arr));
    }

    public int minSwaps(int[][] grid) {
        int result = 0;
        int[] mark = new int[grid.length];
        for (int i = 0; i < mark.length; i++) {
            int count = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                count++;
            }
            mark[i] = count;
        }
        int[] rowCount = new int[grid.length];
        for (int i = 0; i < rowCount.length; i++) {
            rowCount[i] = i;
        }
        int limit = grid.length - 1;
        for (int i = 0; i < grid.length - 1; i++) {
            int minIdx = -1;
            int minGap = Integer.MAX_VALUE;
            for (int j = 0; j < mark.length; j++) {
                if (mark[j] >= limit) {
                    if (rowCount[j] - i < minGap) {
                        minIdx = j;
                        minGap = rowCount[j] - i;
                    }
                }
            }
            if (minIdx == -1) {
                return -1;
            }
            mark[minIdx] = -1;
            result += rowCount[minIdx] - i;
            for (int j = 0; j < rowCount.length; j++) {
                if (rowCount[j] < rowCount[minIdx]) {
                    rowCount[j]++;
                }
            }
            limit--;
        }
        return result;
    }
}
