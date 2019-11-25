package first.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-26
 * https://leetcode.com/problems/word-pattern/
 */

public class Word_Pattern_290 {
    public static void main(String[] args) {
        System.out.println(new Word_Pattern_290().wordPattern("abba", "dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        List<Integer>[] mark = new ArrayList[128];
        for (int i = 0; i < pattern.length(); i++) {
            if (mark[pattern.charAt(i)] == null) {
                List<Integer> t = new ArrayList();
                t.add(i);
                mark[pattern.charAt(i)] = t;
            } else {
                mark[pattern.charAt(i)].add(i);
            }
        }
        Set<String> set = new HashSet();
        for (List<Integer> t : mark) {
            if (t == null) {
                continue;
            }
            String s = arr[t.get(0)];
            if (set.contains(s)) {
                return false;
            }
            set.add(s);
            for (int i = 1; i < t.size(); i++) {
                if (!s.equals(arr[t.get(i)])) {
                    return false;
                }
            }
        }
        return true;
    }
}
