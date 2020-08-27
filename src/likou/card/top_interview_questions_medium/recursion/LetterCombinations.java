package likou.card.top_interview_questions_medium.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv8ka1/
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LetterCombinations().letterCombinations("23").toArray()));
    }

    private String[] t = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        recursion(0, digits, result, new ArrayList());
        return result;
    }

    private void recursion(int start, String digits, List<String> result, List<Character> temp) {
        if (start >= digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char t : temp) {
                sb.append(t);
            }
            result.add(sb.toString());
            return;
        }
        int idx = digits.charAt(start) - '2';
        for (char t : t[idx].toCharArray()) {
            temp.add(t);
            recursion(start + 1, digits, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
