package top_interview_in_2018.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2019/4/10
 * https://leetcode-cn.com/explore/featured/card/top-interview-quesitons-in-2018/275/string/1138/
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList();
        wordDict.add("leet1");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            int idx = (int) c;
            arr[idx] = 1;
        }
        for (String m : wordDict) {
            for (char c : m.toCharArray()) {
                int idx = (int) c;
                arr[idx] = 0;
            }
        }
        for (int t : arr) {
            if (t == 1) {
                return false;
            }
        }
        Set<String> sets = new HashSet<>();
        for (String meta : wordDict) {
            sets.add(meta);
        }
        return wordBreak(s, sets);
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0 || wordDict.contains(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (wordDict.contains(str)) {
                if (wordBreak(s.substring(i + 1, s.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
