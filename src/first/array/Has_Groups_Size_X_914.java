package first.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2019-07-25
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 */

public class Has_Groups_Size_X_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> hashMap = new HashMap();
        for (int t : deck) {
            if (hashMap.containsKey(t)) {
                int count = hashMap.get(t) + 1;
                hashMap.put(t, count);
            } else {
                hashMap.put(t, 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        if (min < 2) {
            return false;
        }
        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() % i == 0) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
