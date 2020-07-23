package likou.company.bytedance.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wuping
 * @date 2020-06-29
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1011/
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */

public class ReverseWords {
    public static void main(String[] args) {
        String t = "a good   example";
        System.out.println(new ReverseWords().reverseWords(t));
    }

    public String reverseWords(String s) {
        if (s ==null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        int start = -1;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t != ' ') {
                if (start < 0) {
                    start = i;
                }
                if (i == s.length() - 1) {
                    int cur = i;
                    while (start >= 0 && cur >= start) {
                        deque.addFirst(s.charAt(cur--));
                    }
                }
            } else {
                if (start < 0) {
                    continue;
                }
                int cur = i - 1;
                while (start >= 0 && cur >= start) {
                    deque.addFirst(s.charAt(cur--));
                }
                deque.addFirst(' ');
                start = -1;
            }
        }
        if (deque.peekFirst() == ' ') {
            deque.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        while (deque.size() > 0) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        s = s.trim();
//        if (s.length() == 0) {
//            return s;
//        }
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
//                continue;
//            }
//            temp.append(s.charAt(i));
//        }
//        // 涉及正则表达式，很慢
//        String[] arr = temp.toString().split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            sb.append(arr[i]);
//            if (i != 0) {
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
//    }
}
