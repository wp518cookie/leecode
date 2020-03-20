package likou.first_try.top;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author wuping
 * @date 2020-02-26
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */

public class LongestCommonPrefix_14 {
    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了5.51%的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了6.58%的用户
     *
     * @param strs
     * @return 时间复杂度 m * n
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        int idx = 0;
        while (true) {
            char temp = 'a';
            for (int i = 0; i < strs.length; i++) {
                String t = strs[i];
                if (t.length() <= idx) {
                    return result;
                }
                if (i == 0) {
                    temp = t.charAt(idx);
                } else {
                    if (temp == t.charAt(idx)) {
                        continue;
                    } else {
                        return result;
                    }
                }
            }
            result += temp;
            idx++;
        }
    }


    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了8.64%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了59.49%的用户
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        int idx = strs[0].length() - 1;
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            idx = Math.min(idx, strs[i].length() - 1);
            for (int j = 0; j <= idx; j++) {
                if (temp.charAt(j) == strs[i].charAt(j)) {
                    continue;
                } else {
                    idx = j - 1;
                    break;
                }
            }
            if (idx < 0) {
                return result;
            }
        }
        return temp.substring(0, idx + 1);
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix1(arr));
    }
}
