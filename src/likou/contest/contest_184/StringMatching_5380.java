package likou.contest.contest_184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-12
 * https://leetcode-cn.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
 */

public class StringMatching_5380 {
    public static void main(String[] args) {
        String[] arr = new String[]{"blue", "ue", "a"};
        System.out.println(Arrays.toString(new StringMatching_5380().stringMatching(arr).toArray()));
    }

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            String t = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() <= t.length()) {
                    continue;
                }
                if (words[j].contains(t)) {
                    result.add(t);
                    break;
                }
            }
        }
        return result;
    }
}
