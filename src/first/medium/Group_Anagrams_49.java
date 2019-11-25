package first.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2019-09-18
 * https://leetcode.com/problems/group-anagrams/
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        if (strs == null || strs.length == 0) {
            return result;
        }
        List<char[]> afterSort = new ArrayList<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            afterSort.add(temp);
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = new String(afterSort.get(i));
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> temp = entry.getValue();
            List<String> tempResult = new ArrayList();
            for (int t : temp) {
                tempResult.add(strs[t]);
            }
            result.add(tempResult);
        }
        return result;
    }

}
