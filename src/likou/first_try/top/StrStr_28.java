package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-10
 * https://leetcode-cn.com/problems/implement-strstr/
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */

public class StrStr_28 {
//    执行用时 :4 ms, 在所有 Java 提交中击败了34.90%的用户
//    内存消耗 :38.3 MB, 在所有 Java 提交中击败了5.05%的用户
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
