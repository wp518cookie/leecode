package likou.contest.contest_182;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-03-29
 * https://leetcode-cn.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
 */

public class FindLucky_5368 {
    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            Integer t = arr[i];
            if (t < 0) {
                continue;
            }
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        int lucky = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t1 = entry.getKey();
            int t2 = entry.getValue();
            if (t1 == t2) {
                lucky = Math.max(lucky, t1);
            }
        }
        return lucky;
    }
}
