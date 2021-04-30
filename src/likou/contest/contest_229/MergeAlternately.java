package likou.contest.contest_229;

/**
 * @author wuping
 * @date 2021-02-21
 * https://leetcode-cn.com/contest/weekly-contest-229/problems/merge-strings-alternately/
 */

public class MergeAlternately {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(new MergeAlternately().mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < word1.length() && idx < word2.length()) {
            sb.append(word1.charAt(idx)).append(word2.charAt(idx));
            idx++;
        }
        while (idx < word1.length()) {
            sb.append(word1.charAt(idx++));
        }
        while (idx < word2.length()) {
            sb.append(word2.charAt(idx++));
        }
        return sb.toString();
    }
}
