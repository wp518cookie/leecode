package likou.contest.contest_198;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-07-19
 */

public class MaxNumOfSubstrings {
    private int count = 1;
    private int totalSize = 0;
    private List<String> result = null;

    public static void main(String[] args) {
        List<String> result = new MaxNumOfSubstrings().maxNumOfSubstrings("abcdefghijklmnopqrstuvwxyz");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public List<String> maxNumOfSubstrings(String s) {
        totalSize = s.length();
        result = new ArrayList<>();
        result.add(s);
        int[][] marked = new int[26][];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (marked[idx] != null) {
                continue;
            }
            int end = s.lastIndexOf(s.charAt(i));
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = end;
            marked[idx] = temp;
        }
        for (int i = 0; i < marked.length; i++) {
            if (marked[i] == null) {
                continue;
            }
            int from = marked[i][0];
            int to = marked[i][1];
            if (from == to) {
                continue;
            }
            boolean[] markedT = new boolean[s.length()];
            while (true) {
                boolean flag = false;
                for (int k = from; k <= to; k++) {
                    if (markedT[k]) {
                        continue;
                    }
                    markedT[k] = true;
                    char t = s.charAt(k);
                    from = Math.min(marked[t - 'a'][0], from);
                    to = Math.max(marked[t - 'a'][1], to);
                    flag = true;
                    break;
                }
                if (!flag) {
                    break;
                }
            }
            marked[i][0] = from;
            marked[i][1] = to;
        }
        recursion(0, marked, new ArrayList(), 0, new ArrayList(), s);
        return result;
    }

    public void recursion(int start, int[][] arr, List<String> current, int size, List<int[]> marked, String s) {
        if (current.size() > count) {
            result = new ArrayList(current);
            totalSize = size;
            count = current.size();
        }
        if (current.size() == count) {
            if (size > totalSize) {
                return;
            } else if (size < totalSize) {
                result = new ArrayList(current);
                totalSize = size;
            }
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            int from = arr[i][0];
            int to = arr[i][1];
            boolean flag = false;
            for (int[] t : marked) {
                if (from <= t[1] && to >= t[0]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            int[] t = new int[]{from, to};
            marked.add(t);
            current.add(s.substring(from, to + 1));
            recursion(i + 1, arr, current, size + to - from + 1, marked, s);
            marked.remove(marked.size() - 1);
            current.remove(current.size() - 1);
        }
    }
}
