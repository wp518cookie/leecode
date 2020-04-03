package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-03
 * https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
