package likou.contest.contest_197;

/**
 * @author wuping
 * @date 2020-07-12
 * https://leetcode-cn.com/contest/weekly-contest-197/problems/number-of-good-pairs/
 */

public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            count[t]++;
        }
        int result = 0;
        for (int i = 0; i < count.length; i++) {
            int t =  count[i];
            if (t == 2) {
                result = result + 1;
            } else if (t > 2) {
                int temp = 1;
                int cTemp = 1;
                for (int j = 3; j <= t; j++) {
                    cTemp = cTemp * j;
                }
                for (int j = 2; j <= t - 2; j++) {
                    cTemp = cTemp / j;
                }
                result = result + cTemp;
            }
        }
        return result;
    }
}
