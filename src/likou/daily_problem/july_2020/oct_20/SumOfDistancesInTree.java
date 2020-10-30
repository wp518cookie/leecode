package likou.daily_problem.july_2020.oct_20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-10-06
 * https://leetcode-cn.com/problems/sum-of-distances-in-tree/
 *
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 *
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 *
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 *
 * 示例 1:
 *
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 *
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 *
 */

public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<Integer>[] edgesList = new ArrayList[N];
        for (int i = 0; i < edgesList.length; i++) {
            edgesList[i] = new ArrayList();
        }
        int[][] mark = new int[N][N];
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark.length; i++) {
                if (i != j) {
                    mark[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

        }
        return null;
    }

    public int recursion(int from, int to, List<Integer>[] edgesList) {
        return 0;
    }
}