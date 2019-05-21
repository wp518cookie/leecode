package geekbang.tanchao.queue_and_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-05-14
 * https://leetcode.com/problems/valid-parentheses/description/
 * Input: "()[]{}"
 * Output: true
 */

public class IsValid {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        List<Character> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(' || t == '{' || t == '[') {
                list.add(t);
                continue;
            }
            if (t == ')') {
                if (list.size() <= 0) {
                    return false;
                } else if (list.remove(list.size() - 1) != '(') {
                    return false;
                }
                continue;
            } else if (t == '}') {
                if (list.size() <= 0) {
                    return false;
                } else if (list.remove(list.size() - 1) != '{') {
                    return false;
                }
                continue;
            } else if (t == ']') {
                if (list.size() <= 0) {
                    return false;
                } else if (list.remove(list.size() - 1) != '[') {
                    return false;
                }
                continue;
            } else {
                return false;
            }
        }
        return list.size() == 0;
    }
}
