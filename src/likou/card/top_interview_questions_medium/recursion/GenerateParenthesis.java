package likou.card.top_interview_questions_medium.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv33m7/
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GenerateParenthesis().generateParenthesis(3).toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        if (n <= 0) {
            return result;
        }
        recursion(n, 0, 0, result, new ArrayList<>());
        return result;
    }

    public void recursion(int n, int lCount, int rCount, List<String> result, List<Character> current) {
        if (lCount == n && rCount == n) {
            StringBuilder sb = new StringBuilder();
            for (char t : current) {
                sb.append(t);
            }
            result.add(sb.toString());
            return;
        }
        if (lCount <= rCount) {
            current.add('(');
            recursion(n, lCount + 1, rCount, result, current);
            current.remove(current.size() - 1);
        } else {
            if (lCount < n) {
                current.add('(');
                recursion(n, lCount + 1, rCount, result, current);
                current.remove(current.size() - 1);
            }
            current.add(')');
            recursion(n, lCount, rCount + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}
