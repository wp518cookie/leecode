package likou.first_try.top;

import java.util.Stack;

/**
 * @author wuping
 * @date 2020-03-20
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(') {
                stack.push('(');
            }
            if (t == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '(') {
                    continue;
                } else {
                    return false;
                }
            }
            if (t == '{') {
                stack.push('{');
            }
            if (t == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '{') {
                    continue;
                } else {
                    return false;
                }
            }
            if (t == '[') {
                stack.push('[');
            }
            if (t == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '[') {
                    continue;
                } else {
                    return false;
                }
             }
        }
        return stack.isEmpty();
    }
}
