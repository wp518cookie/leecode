package likou.contest.contest_193;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-06-14
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/kth-ancestor-of-a-tree-node/
 */

public class TreeAncestor {
    public TreeAncestor(int n, int[] parent) {
        List<Set<Integer>> list = new ArrayList();
        Set<Integer> t = new HashSet();
        t.add(0);
        while (t.size() > 0) {
            Set<Integer> t1 = new HashSet();
            for (int i : t) {

            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k > 31) {
            return -1;
        }
        int t = 1;
        while (k-- > 0) {
            t = (t << 1);
        }
        int result = (node + 1) / t;
        return result - 1;
    }
}
