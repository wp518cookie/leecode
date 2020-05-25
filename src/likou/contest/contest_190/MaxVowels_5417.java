package likou.contest.contest_190;

/**
 * @author wuping
 * @date 2020-05-24
 */

public class MaxVowels_5417 {
    public int maxVowels(String s, int k) {
        int[] t = new int[128];
        t['a'] = -1;
        t['e'] = -1;
        t['i'] = -1;
        t['o'] = -1;
        t['u'] = -1;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (t[s.charAt(i)] == -1) {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            if (t[s.charAt(i - k)] == -1) {
                count--;
            }
            if (t[s.charAt(i)] == -1) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
