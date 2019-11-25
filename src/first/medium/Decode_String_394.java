package first.medium;

import java.util.Stack;

/**
 * @author wuping
 * @date 2019-07-27
 * https://leetcode.com/problems/decode-string/
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class Decode_String_394 {
    public static void main(String[] args) {
        System.out.println(new Decode_String_394().decodeString("2[ab3[cd]]4[xy]"));
    }

    public String decodeString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        Stack<Character> temp = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                int pre = 0;
                while (stack.peek() != '[') {
                    temp.push(stack.pop());
                }
                stack.pop();
                int c = 1;
                while (!stack.isEmpty() && stack.peek() < 65) {
                    pre = pre + c * (stack.pop() - 48);
                    c = c * 10;
                }
                if (stack.isEmpty()) {
                    StringBuilder t = new StringBuilder();
                    while (!temp.isEmpty()) {
                        t.append(temp.pop());
                    }
                    StringBuilder sb1 = new StringBuilder();
                    while (pre-- > 0) {
                        sb1.append(t.toString());
                    }
                    sb.append(sb1);
                } else {
                    char[] arr = new char[temp.size()];
                    int idx = 0;
                    while (!temp.isEmpty()) {
                        arr[idx++] = temp.pop();
                    }
                    while (pre-- > 0) {
                        for (int j = 0; j < arr.length; j++) {
                            stack.push(arr[j]);
                        }
                    }
                }
            } else if (!stack.isEmpty() || s.charAt(i) < 65) {
                stack.push(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
