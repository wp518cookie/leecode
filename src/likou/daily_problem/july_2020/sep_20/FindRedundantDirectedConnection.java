package likou.daily_problem.july_2020.sep_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-09-17
 * https://leetcode-cn.com/problems/redundant-connection-ii/
 * <p>
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * 示例 2:
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * 注意:
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 */

public class FindRedundantDirectedConnection {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}};
//        System.out.println(Arrays.toString(new FindRedundantDirectedConnection().findRedundantDirectedConnection(arr)));
    }

//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        Map<Integer, Set<Integer>> toMark = new HashMap();
//        Map<Integer, Set<Integer>> fromMark = new HashMap();
//        for (int i = 0; i < edges.length; i++) {
//            int[] edge = edges[i];
//            int from = edge[0];
//            int to = edge[1];
//            if (toMark.containsKey(from)) {
//                toMark.get(from).add(to);
//            } else {
//                Set<Integer> toMarkList = new HashSet();
//                toMarkList.add(to);
//                toMark.put(from, toMarkList);
//            }
//            if (fromMark.containsKey(to)) {
//                fromMark.get(to).add(from);
//            } else {
//                Set<Integer> fromMarkList = new HashSet();
//                fromMarkList.add(from);
//                fromMark.put(to, fromMarkList);
//            }
//        }
//        // 先找有没有两个节点是被入的
//        Map.Entry<Integer, Set<Integer>> mark = null;
//        for (Map.Entry<Integer, Set<Integer>> entry : fromMark.entrySet()) {
//            if (entry.getValue().size() > 1) {
//                mark = entry;
//            }
//        }
//        if (mark != null) {
//            for (int i = edges.length - 1; i >= 0; i--) {
//                int[] t = edges[i];
//                int to = mark.getKey();
//                Set<Integer> fromSet = mark.getValue();
//                if (t[1] == to) {
//                    if (fromSet.contains(t[0])) {
//                        for (Integer fromMeta : fromSet) {
//
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = edges.length - 1; i >= 0; i--) {
//            int[] t = edges[i];
//            int from = t[0];
//            int to = t[1];
//            if (toMark.get(from).size() == 1 && fromMark.get(from) == null) {
//                continue;
//            }
//            return t;
//        }
//        return null;
//    }
}
