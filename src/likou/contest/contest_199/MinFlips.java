package likou.contest.contest_199;

/**
 * @author wuping
 * @date 2020-07-26
 */

public class MinFlips {
    public int minFlips(String target) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                if (count % 2 == 0) {
                    count++;
                } else {
                    continue;
                }
            } else {
                if (count % 2 == 0) {
                    continue;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
