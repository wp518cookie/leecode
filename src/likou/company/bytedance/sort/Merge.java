package likou.company.bytedance.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-06-04
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1046/
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

public class Merge {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new Merge().merge(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println(Arrays.toString(new Merge().merge(arr)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        if (intervals.length == 1) {
            return intervals;
        }
        List<Pair> list = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, (a, b) -> {
           if (a.start == b.start) {
               return a.end - b.end;
           } else {
               return a.start - b.start;
           }
        });
        for (int i = 1; i < list.size(); i++) {
            Pair cur = list.get(i);
            Pair pre = list.get(i - 1);
            if (cur.end >= pre.start && pre.end >= cur.start) {
                cur.start = Math.min(cur.start, pre.start);
                cur.end = Math.max(cur.end, pre.end);
                pre.start = -1;
                pre.end = -1;
            }
        }
        List<Pair> result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Pair t = list.get(i);
            if (t.start == -1) {
                continue;
            }
            result.add(t);
        }
        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i][0] = result.get(i).start;
            resultArr[i][1] = result.get(i).end;
        }
        return resultArr;
    }

    private static class Pair {
        private int start;
        private int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

//    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] result = new Merge().merge(arr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }
//    }
//
//    public int[][] merge(int[][] intervals) {
//        int[][] result = new int[intervals.length][];
//        int count = 0;
//        for (int i = 1; i < intervals.length; i++) {
//            int s1 = intervals[i][0];
//            int e1 = intervals[i][1];
//            if (count == 0) {
//                result[count] = new int[2];
//                result[count][0] = s1;
//                result[count++][1] = e1;
//            }
//            for (int j = 0; j < result.length; j++) {
//                if (result[j] == null) {
//                    continue;
//                }
//                int s2 = result[j][0];
//                int e2 = result[j][1];
//                if (s1 > s2) {
//                    if (s1 > e2) {
//                        result[count] = new int[2];
//                        result[count][0] = s1;
//                        result[count++][1] = e1;
//                    } else {
//                        if (e1 > e2) {
//                            result[j][1] = e1;
//                        }
//                    }
//                } else {
//                    if (e1 < s2) {
//                        result[count] = new int[2];
//                        result[count][0] = s1;
//                        result[count++][1] = e1;
//                    } else {
//                        if (e1 > e2) {
//                            result[j][0] = s1;
//                            result[j][1] = e1;
//                        } else {
//                            result[j][1] = e2;
//                        }
//                    }
//                }
//            }
//        }
//        int t = 0;
//        for (int i = 0; i < result.length; i++) {
//            if (result[i] == null) {
//                continue;
//            }
//            result[t][0] = result[i][0];
//            result[t++][1] = result[i][1];
//        }
//        int[][] r = new int[t][2];
//        for (int i = 0; i < t; i++) {
//            r[i][0] = result[i][0];
//            r[i][1] = result[i][1];
//        }
//        return r;
//    }
}
