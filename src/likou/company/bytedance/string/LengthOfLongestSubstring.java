package likou.company.bytedance.string;

/**
 * @author wuping
 * @date 2020-06-15
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1012/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] t = new int[128];
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }
        int count = 1;
        int startIdx = 0;
        t[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
            int idx = s.charAt(i);
            if (t[idx] == -1) {
                t[idx] = i;
            } else {
                if (t[idx] < startIdx) {
                    t[idx] = i;
                } else {
                    count = Math.max(i - startIdx, count);
                    startIdx = t[idx] + 1;
                    t[idx] = i;
                }
            }
        }
        int tcount = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] >= startIdx) {
                tcount++;
            }
        }
        count = Math.max(tcount, count);
        return count;
    }
}
