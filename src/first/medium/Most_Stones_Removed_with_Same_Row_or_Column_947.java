package first.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-12-14
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 *
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 *
 * What is the largest possible number of moves we can make?
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 */

public class Most_Stones_Removed_with_Same_Row_or_Column_947 {
    public int removeStones(int[][] stones) {
        if (stones == null) {
            return 0;
        }
        Map<Integer, List<Integer>> xMapping = new HashMap();
        Map<Integer, List<Integer>> yMapping = new HashMap();
        for (int i = 0; i < stones.length; i++) {
            int[] temp = stones[i];
            if (xMapping.containsKey(temp[0])) {
                xMapping.get(temp[0]).add(temp[1]);
            } else {
                List<Integer> list = new ArrayList();
                list.add(temp[1]);
                xMapping.put(temp[0], list);
            }
            if (yMapping.containsKey(temp[1])) {
                yMapping.get(temp[1]).add(temp[0]);
            } else {
                List<Integer> list = new ArrayList();
                list.add(temp[0]);
                yMapping.put(temp[1], list);
            }
        }
        Set<Integer> set = new HashSet();
        set.add((stones[0][1] << 14) + stones[0][0]);
        return dfs(stones[0][0], stones[0][1], set, xMapping, yMapping);
    }

    private int dfs(int i, int j, Set<Integer> set, Map<Integer, List<Integer>> xMapping, Map<Integer, List<Integer>> yMapping) {
        int count = 0;
        List<Integer> meta1 = xMapping.get(i);
        List<Integer> meta2 = yMapping.get(j);
        if (meta1 != null && meta1.size() > 0) {
            for (int t : meta1) {
                int key = (t << 14) + i;
                if (set.contains(key)) {
                    continue;
                } else {
                    set.add(key);
                    count += 1 + dfs(i, t, set, xMapping, yMapping);
                }
            }
        }
        if (meta2 != null && meta2.size() > 0) {
            for (int t : meta2) {
                int key = (j << 14) + t;
                if (set.contains(key)) {
                    continue;
                } else {
                    set.add(key);
                    count += 1 + dfs(t, j, set, xMapping, yMapping);
                }
            }
        }
        return count;
    }
}
