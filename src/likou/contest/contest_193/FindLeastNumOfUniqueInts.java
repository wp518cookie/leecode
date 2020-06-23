package likou.contest.contest_193;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-06-14
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/least-number-of-unique-integers-after-k-removals/
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 */

public class FindLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        int count = map.size();
        if (k == 0) {
            return map.size();
        }
        TreeMap<Integer, Integer> tree = new TreeMap();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (tree.containsKey(entry.getValue())) {
                tree.put(entry.getValue(), tree.get(entry.getValue()) + 1);
            } else {
                tree.put(entry.getValue(), 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (k < key) {
                break;
            } else {
                while (k >= key && val > 0) {
                    k = k - key;
                    val--;
                    count--;
                }
            }
        }
        return count;
    }
}
