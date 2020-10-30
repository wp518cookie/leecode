package likou.contest.contest_208;

/**
 * @author wuping
 * @date 2020-09-27
 * https://leetcode-cn.com/contest/weekly-contest-208/problems/crawler-log-folder/
 */

public class MinOperations {
    public int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            String s = logs[i];
            if (s.equals("./")) {
                continue;
            } else if (s.equals("../")) {
                count = count == 0 ? 0 : count - 1;
            } else {
                count++;
            }
        }
        return count;
    }
}
