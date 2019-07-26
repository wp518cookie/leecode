package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2019-07-26
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */

public class Find_LHS_594 {
    public static void main(String[] args) {
        System.out.println(new Find_LHS_594().findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            Integer c = map.get(i);
            if (c == null) {
                map.put(i, 1);
            } else {
                map.put(i, c + 1);
            }
        }
        int count = 0;
        int pre;
        int after;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pre = map.get(entry.getKey() - 1) == null ? 0 : map.get(entry.getKey() - 1);
            after = map.get(entry.getKey() + 1) == null ? 0 : map.get(entry.getKey() + 1);
            if (after > pre) {
                if (count < entry.getValue() + after) {
                    count = entry.getValue() + after;
                }
            } else if (after < pre) {
                if (count < entry.getValue() + pre) {
                    count = entry.getValue() + pre;
                }
            } else {
                if (pre == 0) {
                    continue;
                }
            }
        }
        return count;
    }
}
