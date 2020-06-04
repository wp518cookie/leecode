package likou.contest.doubleweek.contest_27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-05-30
 * https://leetcode-cn.com/contest/biweekly-contest-27/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */

public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        int[] mark = new int[1001];
        for (int i = 0; i < target.length; i++) {
            mark[target[i]] ++;
        }
        for (int i = 0; i < target.length; i++) {
            int t = arr[i];
            if (mark[t] <= 0) {
                return false;
            } else {
                mark[t]--;
            }
        }
        return true;
    }
}
