package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2019-07-26
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */

public class Uncommon_From_Sentences_884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] A_arr = A.split(" ");
        String[] B_arr = B.split(" ");
        Map<String, Integer> map = new HashMap();
        for (String t : A_arr) {
            Integer c = map.get(t);
            if (c == null) {
                map.put(t, 1);
            } else {
                map.put(t, c + 1);
            }
        }
        for (String t : B_arr) {
            Integer c = map.get(t);
            if (c == null) {
                map.put(t, 1);
            } else {
                map.put(t, c + 1);
            }
        }
        List<String> result = new ArrayList();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}
