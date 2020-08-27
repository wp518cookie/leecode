package likou.card.top_interview_questions_medium.arr_and_string;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/
 *
 * 定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class LongestPalindrome {
    /**
     * 执行用时：
     * 41 ms, 在所有 Java 提交中击败了65.56%的用户
     * 内存消耗：
     * 37.6 MB, 在所有 Java 提交中击败了98.66%的用户
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int count = 0;
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        int length = s.length();
        for (int i = 0; i < 2 * length - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > count) {
                    start = left;
                    end = right;
                    count = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end + 1);
    }
}
