package likou.contest.contest_179;

/**
 * @author wuping
 * @date 2020-03-08
 * https://leetcode-cn.com/contest/weekly-contest-179/problems/bulb-switcher-iii/
 */

public class NumTimesAllBlue_5353 {
    public int numTimesAllBlue(int[] light) {
        int blueIdx = -1;
        int openIdx = -1;
        int count = 0;
        int[] initial = new int[light.length];
        for (int i = 0; i < light.length; i++) {
            int idx = light[i] - 1;
            openIdx = Math.max(openIdx, idx);
            initial[idx] = 1;
            if (blueIdx + 1 == idx) {
                blueIdx++;
                while (true) {
                    if (blueIdx + 1 < light.length) {
                        if (initial[blueIdx + 1] == 1) {
                            blueIdx++;
                        } else {
                            break;
                        }
                    } else {
                       break;
                    }
                }
                if (blueIdx == openIdx) {
                    count++;
                }
            }
        }
        return count;
    }
}
