package likou.daily_problem.july_2020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-24
 * <p>
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * <p>
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String t = "abaababaabc";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(t));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int maxLength = s.length() / 2;
        for (int i = 1; i <= maxLength; i++) {
            if (s.length() % i != 0) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < s.length() / i - 1; j++) {
                for (int k = 0; k < i; k++) {
                    if (s.charAt(k + (j * i)) != s.charAt(k + ((j + 1) * i))) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
