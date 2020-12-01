package likou.daily_problem.july_2020.nov_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-11-05
 */

public class LadderLength {

    public static void main(String[] args) {
        String beginWord = "hog";
        String endWord = "cog";
        List<String> list = new ArrayList();
        list.add("cog");
        System.out.println(new LadderLength().ladderLength(beginWord, endWord, list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 1) {
            return 0;
        }
        Map<String, List<String>> mark = new HashMap();
        for (int i = 0; i < wordList.size(); i++) {
            if (check(beginWord, wordList.get(i))) {
                addToMark(beginWord, wordList.get(i), mark);
            }
        }
        for (int i = 0; i < wordList.size() - 1; i++) {
            String first = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String second = wordList.get(j);
                if (check(first, second)) {
                    addToMark(first, second, mark);
                    addToMark(second, first, mark);
                }
            }
        }
        if (!mark.containsKey(beginWord)) {
            return 0;
        }
        Set<String> recursionMark = new HashSet();
        recursionMark.add(beginWord);
        List<String> list = new ArrayList();
        list.add(beginWord);
        int count = 2;
        while (list.size() > 0) {
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                List<String> tempList = mark.get(list.get(i));
                for (String t : tempList) {
                    if (recursionMark.contains(t)) {
                        continue;
                    } else {
                        recursionMark.add(t);
                        if (t.equals(endWord)) {
                            return count;
                        } else {
                            newList.add(t);
                        }
                    }
                }
            }
            count++;
            if (newList.size() == 0) {
                return 0;
            }
            list = newList;
        }
        return count;
    }

    private void addToMark(String key, String val, Map<String, List<String>> mark) {
        if (mark.containsKey(key)) {
            mark.get(key).add(val);
        } else {
            List<String> vals = new ArrayList();
            vals.add(val);
            mark.put(key, vals);
        }
    }

    public boolean check(String wordA, String wordB) {
        int diffCount = 0;
        for (int i = 0; i < wordA.length(); i++) {
            if (wordA.charAt(i) != wordB.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
}
