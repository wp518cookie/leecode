package likou.contest.contest_179;

/**
 * @author wuping
 * @date 2020-03-08
 * https://leetcode-cn.com/contest/weekly-contest-179/problems/generate-a-string-with-characters-that-have-odd-counts/
 */

public class GenerateTheString_5352 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        } else {
            sb.append('a');
            for (int i = 1; i < n; i++) {
                sb.append('b');
            }
        }
        return sb.toString();
    }
}
