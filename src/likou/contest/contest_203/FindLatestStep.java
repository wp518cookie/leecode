package likou.contest.contest_203;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-23
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/find-latest-group-of-size-m/
 */

public class FindLatestStep {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 2, 4};
        System.out.println(new FindLatestStep().findLatestStep(arr, 1));
    }

    public int findLatestStep(int[] arr, int m) {
        boolean[] mark = new boolean[arr.length + 1];
        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            mark[t] = true;
            int l = t - 1;
            int r = t + 1;
            int size = 1;
            while (true) {
                if (l > 0 && mark[l]) {
                    l--;
                    size++;
                    continue;
                }
                if (r < mark.length && mark[r]) {
                    r++;
                    size++;
                    continue;
                }
                break;
            }
            if (count.containsKey(size) && size == m) {
                return i + 1;
            }
        }
        return -1;
    }
}
