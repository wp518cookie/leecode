package likou.card.top_interview_questions_medium.arr_and_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class GroupAnagrams {
    /**
     * 执行用时：
     * 13 ms, 在所有 Java 提交中击败了31.62%的用户
     * 内存消耗：
     * 43.2 MB, 在所有 Java 提交中击败了22.15%的用户
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> mark = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String t = strs[i];
            String sortedT = sort(t);
            if (mark.containsKey(sortedT)) {
                mark.get(sortedT).add(t);
            } else {
                List<String> temp = new ArrayList();
                temp.add(t);
                mark.put(sortedT, temp);
            }
        }
        for (Map.Entry<String, List<String>> entry : mark.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String sort(String t) {
        int[] mark = new int[26];
        for (int i = 0; i < t.length(); i++) {
            mark[t.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mark.length; i++) {
            while (mark[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
