package likou.company.bytedance.string;

/**
 * @author wuping
 * @date 2020-06-15
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1014/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"aca", "cba"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr));
    }

    // 两两比较即可
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        if (strs.length == 1) {
            return commonPrefix;
        }
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.length() == 0) {
                return "";
            }
        }
        return commonPrefix;
    }
//      可以优化下是空间复杂度
//    public String getCommonPrefix(String s1, String s2) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
//            if (s1.charAt(i) == s2.charAt(i)) {
//                sb.append(s1.charAt(i));
//            } else {
//                return sb.toString();
//            }
//        }
//        return sb.toString();
//    }

    public String getCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
