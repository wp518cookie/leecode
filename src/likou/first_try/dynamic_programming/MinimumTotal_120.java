package likou.first_try.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-16
 * https://leetcode-cn.com/problems/triangle/
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

public class MinimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> pre = new ArrayList();
        pre.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currentList = triangle.get(i);
            List<Integer> cur = new ArrayList();
            cur.add(currentList.get(0) + pre.get(0));
            for (int j = 1; j < currentList.size() - 1; j++) {
                cur.add(currentList.get(j) + (Math.min(pre.get(j - 1), pre.get(j))));
            }
            cur.add(currentList.get(currentList.size() - 1) + pre.get(pre.size() - 1));
            pre = cur;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pre.size(); i++) {
            min = Math.min(pre.get(i), min);
        }
        return min;
    }
}
