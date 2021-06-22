package likou.daily_problem.june_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2021-06-22
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * 限制：
 * 1 <= s 的长度 <= 8
 */

public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(new Permutation().permutation(s)));
    }

    //todo 优化解法
    public String[] permutation(String s) {
        Map<Character, Integer> mark = new HashMap();
        for (char t : s.toCharArray()) {
            if (mark.containsKey(t)) {
                mark.put(t, mark.get(t) + 1);
            } else {
                mark.put(t, 1);
            }
        }
        char[] t = s.toCharArray();
        Arrays.sort(t);

        List<String> result = new ArrayList<>();
        recusion(t, 0, mark, new ArrayList<>(), result);
        String[] arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public void recusion(char[] arr, int count, Map<Character, Integer> mark, List<Character> cur, List<String> result) {
        if (count == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (char t : cur) {
                sb.append(t);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if (mark.get(arr[i]) <= 0) {
                continue;
            }
            cur.add(arr[i]);
            mark.put(arr[i], mark.get(arr[i]) - 1);
            recusion(arr, count + 1, mark, cur, result);
            cur.remove(cur.size() - 1);
            mark.put(arr[i], mark.get(arr[i]) + 1);
        }
    }
}
