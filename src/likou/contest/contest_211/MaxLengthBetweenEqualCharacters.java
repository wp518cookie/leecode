package likou.contest.contest_211;

/**
 * @author wuping
 * @date 2020-10-18
 * https://leetcode-cn.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/
 */

public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
        String s = "scayofdzca";
        System.out.println(new MaxLengthBetweenEqualCharacters().maxLengthBetweenEqualCharacters(s));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] lowMark = new int[26];
        int[] highMark = new int[26];
        for (int i = 0; i < 26; i++) {
            lowMark[i] = Integer.MAX_VALUE;
            highMark[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            lowMark[idx] = Math.min(lowMark[idx], i);
            highMark[idx] = Math.max(highMark[idx], i);
        }
        int result = -1;
        for (int i = 0; i < 26; i++) {
            if (lowMark[i] >= highMark[i]) {
                continue;
            }
            int temp = highMark[i] - lowMark[i] - 1;
            if (temp >= 0) {
                result = Math.max(temp, result);
            }
        }
        return result;
    }
}
