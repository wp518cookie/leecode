package top_interview_in_2018.string;

/**
 * @author wuping
 * @date 2019/3/18
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/275/string/1136/
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 0 - 9    48 - 57
 * a - z    97 - 122
 * A - Z    65 - 90
 */

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int t1 = transfer(arr[i]);
            while (t1 == -1) {
                i++;
                if (i < j) {
                    t1 = transfer(arr[i]);
                } else {
                    return true;
                }
            }
            int t2 = transfer(arr[j]);
            while (t2 == -1) {
                j--;
                if (i < j) {
                    t2 = transfer(arr[j]);
                } else {
                    return true;
                }
            }
            if (t1 != t2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int transfer(char t) {
        if (t < 48 ||
                (t > 57 && t < 65) ||
                (t > 90 && t < 97) ||
                (t > 122)) {
            return -1;
        }
        if (t >= 97) {
            t = (char) ((int) t - 32);
        }
        return t;
    }
}
