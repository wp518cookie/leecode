package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-10-18
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 */

public class Unique_Number_of_Occurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int t : arr) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        Set<Integer> set = new HashSet();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            } else {
                set.add(entry.getValue());
            }
        }
        return true;
    }
}
