package likou.contest.contest_201;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-08-09
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/make-the-string-great/
 */

public class MakeGood {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(new MakeGood().makeGood(s));
    }

    public String makeGood(String s) {
        if (s.length() == 1) {
            return s;
        }
        boolean capitalFlag = true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            boolean isCapital = isCapital(t);
            if (stack.size() == 0) {
                stack.push(t);
                if (isCapital) {
                    capitalFlag = true;
                } else {
                    capitalFlag = false;
                }
            } else {
                if (capitalFlag) {
                    if (isCapital) {
                        stack.push(t);
                    } else {
                        stack.pop();
                    }
                } else {
                    if (isCapital) {
                        stack.pop();
                    } else {
                        stack.push(t);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }

    public boolean isCapital(Character t) {
        if (t < 'a') {
            return true;
        }
        return false;
    }
}
