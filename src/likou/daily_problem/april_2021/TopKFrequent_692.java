package likou.daily_problem.april_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2021-05-20
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。

 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */

public class TopKFrequent_692 {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> mark = new HashMap();
        for (String t : words) {
            if (mark.containsKey(t)) {
                mark.put(t, mark.get(t) + 1);
            } else {
                mark.put(t, 1);
            }
        }
        TreeMap<Integer, List<String>> count = new TreeMap((a, b) -> (int) b - (int)a);
        for (Map.Entry<String, Integer> entry : mark.entrySet()) {
            if (count.containsKey(entry.getValue())) {
                count.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                count.put(entry.getValue(), list);
            }
        }
        List<String> result = new ArrayList<>();
        int neededNum = k;
        for (Map.Entry<Integer, List<String>> entry : count.entrySet()) {
            if (neededNum == 0) {
                return result;
            }
            if (neededNum > entry.getValue().size()) {
                result.addAll(entry.getValue());
            } else {
                result.addAll(find(entry.getValue(), neededNum));
                return result;
            }
        }
        return result;
    }

    public List<String> find(List<String> origin, int count) {
        return null;
    }
}
