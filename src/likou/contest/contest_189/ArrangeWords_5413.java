package likou.contest.contest_189;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-05-17
 * https://leetcode-cn.com/contest/weekly-contest-189/problems/rearrange-words-in-a-sentence/
 */

public class ArrangeWords_5413 {
    public static void main(String[] args) {
        String text = "Leetcode is cool";
        System.out.println(new ArrangeWords_5413().arrangeWords(text));
    }

    public String arrangeWords(String text) {
        Map<Integer, List<String>> map = new TreeMap<>();
        text = (char)(text.charAt(0) + 32) + text.substring(1);
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String t = arr[i];
            int length = t.length();
            if (map.containsKey(length)) {
                map.get(length).add(t);
            } else {
                List<String> list = new ArrayList();
                list.add(t);
                map.put(length, list);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            for(String t : list) {
                sb.append(t);
                sb.append(" ");
            }
        }
        String result = sb.toString();
        return (char)(result.charAt(0) - 32) + result.substring(1, result.length() - 1);
    }
}
