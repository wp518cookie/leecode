package likou.contest.contest_194;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-06-21
 * https://leetcode-cn.com/contest/weekly-contest-194/problems/making-file-names-unique/
 */

public class GetFolderNames {
    public static void main(String[] args) {
        String[] arr = new String[]{"kaido","kaido(1)","kaido","kaido(1)"};
        System.out.println(Arrays.toString(new GetFolderNames().getFolderNames(arr)));
    }
    public String[] getFolderNames(String[] names) {
        LinkedHashSet<String> set = new LinkedHashSet();
        Map<String, Integer> count = new HashMap();
        for (int i = 0; i < names.length; i++) {
            String t = names[i];
            if (set.contains(t)) {
                String after = addSuffix(t, set, count);
                set.add(after);
                if (count.containsKey(after)) {
                    count.put(after, count.get(after) + 1);
                } else {
                    count.put(after, 1);
                }
            } else {
                set.add(t);
                count.put(t, 1);
            }
        }
        String[] result = new String[set.size()];
        int i = 0;
        for (String t : set) {
            result[i++] = t;
        }
        return result;
    }

    public String addSuffix(String t, Set<String> set, Map<String, Integer> count) {
        int k = count.get(t);
        while (true) {
            StringBuilder sb = new StringBuilder(t);
            sb.append("(").append(k).append(")");
            String result = sb.toString();
            if (set.contains(result)) {
                k++;
            } else {
                count.put(t, k + 1);
                return result;
            }
        }
    }
}
