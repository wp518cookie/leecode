package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-04
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */

public class ReverseString_344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char t = s[i];
            s[i] = s[length - i];
            s[length - i] = t;
        }
    }
}
