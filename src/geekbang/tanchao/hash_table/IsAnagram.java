package geekbang.tanchao.hash_table;

/**
 * @author wuping
 * @date 2019-05-21
 * https://leetcode.com/problems/valid-anagram/description/
 */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (char metaS : s.toCharArray()) {
            int idx = (int) metaS - 97;
            chars[idx]++;
        }
        for (char metaT : t.toCharArray()) {
            int idx = (int) metaT - 97;
            if (chars[idx]-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
