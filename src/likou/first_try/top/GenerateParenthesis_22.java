package likou.first_try.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-08
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        List<String> result = new GenerateParenthesis_22().generateParenthesis(3);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        recursion(n, 0, 0, "", result);
        return result;
    }

    private void recursion(int n, int left, int right, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            recursion(n, left + 1, right, s + '(', result);
        }
        if (right < n && left > right) {
            recursion(n, left, right + 1, s + ')', result);
        }
    }
}
