package likou.first_try.top;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-03-20
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 输入: "race a car"
 * 输出: false
 */

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        new ValidPalindrome_125().isPalindrome("A man, a plan, a canal: Panama");
    }
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> list = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char temp = isInRegion(s.charAt(i));
            if (temp != 0) {
                list.add(temp);
            }
        }
        if (list.size() == 0) {
            return true;
        }
        int count = list.size() / 2;
        while (count-- > 0) {
            if (!list.pollFirst().equals(list.pollLast())) {
                return false;
            }
        }
        return true;
    }

    private char isInRegion(char t) {
        if (t >= '0' && t <= '9') {
            return t;
        }
        if (t >= 'a' && t <= 'z') {
            return t;
        }
        if (t >= 'A' && t <= 'Z') {
            return (char)(t + 32);
        }
        return (char) 0;
    }
}
