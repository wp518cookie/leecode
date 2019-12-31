package first.contest.contest_169;

/**
 * @author wuping
 * @date 2019-12-29
 * https://leetcode.com/contest/weekly-contest-169/problems/jump-game-iii/
 */

public class Jump_Game_III_5297 {
    public boolean canReach(int[] arr, int start) {
        int val = arr[start];
        if (val == 0) {
            return true;
        }
        if (val < 0) {
            return false;
        }
        arr[start] = -1;
        boolean result = false;
        if (start + val < arr.length) {
            result = result | canReach(arr, start + val);
        }
        if (start - val >= 0) {
            result = result | canReach(arr, start - val);
        }
        return result;
    }
}
