package likou.contest.contest_182;

/**
 * @author wuping
 * @date 2020-03-29
 * https://leetcode-cn.com/contest/weekly-contest-182/problems/count-number-of-teams/
 */

public class NumTeams_5369 {
    public static void main(String[] args) {
        new NumTeams_5369().numTeams(new int[]{2,5,3,4,1});
    }
    public int numTeams(int[] rating) {
        int[] bigger = new int[rating.length];
        int[] lower = new int[rating.length];
        for (int i = 0; i < rating.length - 1; i++) {
            int t = rating[i];
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > t) {
                    bigger[i]++;
                } else if (rating[j] < t) {
                    lower[i]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            int t1 = rating[i];
            for (int j = i + 1; j < rating.length; j++) {
                int t2 = rating[j];
                if (t1 > t2) {
                    count += lower[j];
                } else if (t1 < t2) {
                    count += bigger[j];
                }
            }
        }
        return count;
    }
}
