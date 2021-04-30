package likou.contest.contest_219;

/**
 * @author wuping
 * @date 2020-12-13
 * https://leetcode-cn.com/contest/weekly-contest-219/problems/count-of-matches-in-tournament/
 */

public class NumberOfMatches {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        int count = 0;
        while (n != 1) {
            int t = n / 2;
            if (n % 2 == 0) {
                n = t;
            } else {
                n = t + 1;
            }
            count += t;
        }
        return count;
    }
}
