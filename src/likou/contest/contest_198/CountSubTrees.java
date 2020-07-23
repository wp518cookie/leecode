package likou.contest.contest_198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-07-19
 */

public class CountSubTrees {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{0, 2}, {0, 3}, {1, 2}};
        System.out.println(Arrays.toString(new CountSubTrees().countSubTrees(4, edges, "aeed")));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                List<Integer> list = new ArrayList();
                list.add(to);
                map.put(from, list);
            }
            if (map.containsKey(to)) {
                map.get(to).add(from);
            } else {
                List<Integer> list = new ArrayList();
                list.add(from);
                map.put(to, list);
            }
        }
        boolean[] marked = new boolean[n];
        Map<Character, Integer> count = new HashMap();
        int[] result = new int[n];
        recursion(0, marked, labels, map, result);
        return result;
    }

    public Map<Character, Integer> recursion(int i, boolean[] marked, String labels, Map<Integer, List<Integer>> map, int[] result) {
        marked[i] = true;
        List<Integer> others = map.get(i);
        Map<Character, Integer> count = new HashMap();
        if (others != null) {
            for (Integer t : others) {
                if (marked[t]) {
                    continue;
                }
                Map<Character, Integer> temp = recursion(t, marked, labels, map, result);
                for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
                    if (count.containsKey(entry.getKey())) {
                        count.put(entry.getKey(), count.get(entry.getKey()) + entry.getValue());
                    } else {
                        count.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        char t = labels.charAt(i);
        if (count.containsKey(t)) {
            count.put(t, count.get(t) + 1);
        } else {
            count.put(t, 1);
        }
        result[i] = count.get(t);
        return count;
    }
}
