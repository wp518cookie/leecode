package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-10-02
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int[] mark = new int[128];
        for (int i = 0; i < 128; i++) {
            mark[i] = -1;
        }
        for (int i = 0; i < J.length(); i++) {
            mark[J.charAt(i)] = 0;
        }
        for (int i = 0; i < S.length(); i++) {
            int t = S.charAt(i);
            if (mark[t] < 0) {
                continue;
            } else {
                mark[t]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 128; i++) {
            if (mark[i] > 0) {
                result += mark[i];
            }
        }
        return result;
    }
}
