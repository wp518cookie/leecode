package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-26
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/、
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinations {
    private static final String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        recursion(0, digits, result, new ArrayList());
        return result;
    }

    private void recursion(int start, String digits, List<String> result, List<Character> current) {
        if (start >= digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char t : current) {
                sb.append(t);
            }
            result.add(sb.toString());
            return;
        }
        String s = arr[digits.charAt(start) - '2'];
        for (int i = 0; i < s.length(); i++) {
            current.add(s.charAt(i));
            recursion(start + 1, digits, result, current);
            current.remove(current.size() - 1);
        }
    }
}
