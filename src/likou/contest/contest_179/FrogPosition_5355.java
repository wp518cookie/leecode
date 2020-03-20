package likou.contest.contest_179;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author wuping
 * @date 2020-03-08
 * https://leetcode-cn.com/contest/weekly-contest-179/problems/frog-position-after-t-seconds/
 */

public class FrogPosition_5355 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{2, 1}, {3, 2}};
        System.out.println(new FrogPosition_5355().frogPosition(8, edges, 7, 7));
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) {
            return 1;
        }
        List<Integer>[] table = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            table[i] = new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            table[from].add(to);
            table[to].add(from);
        }

        List<Integer>[] newTable = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            newTable[i] = new ArrayList();
        }

        int[] parents = new int[n + 1];

        parents[1] = -1;

        for (int i = 1; i < table.length; i++) {
            List<Integer> children = table[i];
            if (children.size() > 0) {
                for (Integer child : children) {
                    if (parents[child] == 0) {
                        parents[child] = i;
                    }
                }
            }
        }

        if (target == 1) {
            if (t == 0) {
                return 1;
            } else {
                return table[1].size() > 0 ? 0 : 1;
            }
        }

        double result = 1;
        int used = 0;
        int current = target;
        while (current != 1) {
            int parent = parents[current];
            int size = table[parent].size();
            if (parent != 1) {
                size--;
            }
            result = result / size;
            used++;
            current = parent;
        }
        if (used > t) {
            return 0;
        } else if (used < t) {
            return table[target].size() == 1 ? result : 0;
        } else {
            return result;
        }
    }
}
