package first.dynamic_programming.medium;

/**
 * @author wuping
 * @date 2020-09-14
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 */

public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("24726"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int ppre = s.charAt(0) == '0' ? 0 : 1;
        if (ppre == 0) {
            return 0;
        }
        int pre = s.charAt(1) == '0' ? 0 : 1;
        if (check(s, 1)) {
            pre++;
        }
        if (pre == 0) {
            return 0;
        }
        int cur = pre;
        for (int i = 2; i < s.length(); i++) {
            cur = 0;
            if (s.charAt(i) == '0') {
                if (check(s, i)) {
                    cur = ppre;
                }
                ppre = pre;
                pre = cur;
            } else {
                cur = pre;
                if (check(s, i)) {
                    cur = cur + ppre;
                }
                ppre = pre;
                pre = cur;
            }
            if (cur == 0) {
                return 0;
            }
        }
        return cur;
    }

    private boolean check(String s, int i) {
        if (i == 0) {
            return false;
        }
        char t = s.charAt(i - 1);
        if (t == '1') {
            return true;
        } else if (t == '2' && s.charAt(i) < '7') {
            return true;
        }
        return false;
    }
}
