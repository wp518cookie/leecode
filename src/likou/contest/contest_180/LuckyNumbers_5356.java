package likou.contest.contest_180;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-03-15
 */

public class LuckyNumbers_5356 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList();
        Set<Integer> minSet = new HashSet();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minSet.add(min);
        }

        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            if (minSet.contains(max)) {
                result.add(max);
            }
        }
        return result;
    }
}
