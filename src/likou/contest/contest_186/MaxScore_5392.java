package likou.contest.contest_186;

/**
 * @author wuping
 * @date 2020-04-26
 * https://leetcode-cn.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
 */

public class MaxScore_5392 {
    public static void main(String[] args) {
        System.out.println(new MaxScore_5392().maxScore("00"));
    }
    public int maxScore(String s) {
        int[] zeroCount = new int[s.length()];
        int[] oneCount = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            zeroCount[i] = zeroCount[i - 1] + (s.charAt(i - 1) == '0' ? 1 : 0);
        }
        oneCount[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = s.length() - 2; i > 0; i--) {
            oneCount[i] = oneCount[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int maxCount = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            maxCount = Math.max(zeroCount[i] + oneCount[i], maxCount);
        }
        return maxCount;
    }
}
