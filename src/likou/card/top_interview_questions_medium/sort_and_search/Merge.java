package likou.card.top_interview_questions_medium.sort_and_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-08-31
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv11yj/
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * 提示
 * intervals[i][0] <= intervals[i][1]
 */

public class Merge {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < intervals.length; i++) {
            int from = intervals[i][0];
            int to = intervals[i][1];
            if (map.containsKey(from)) {
                map.put(from, Math.max(map.get(from), to));
            } else {
                map.put(from, to);
            }
        }
        Map<Integer, Integer> result = new TreeMap<>();
        int preFrom = -1;
        int preTo = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int from = entry.getKey();
            int to = entry.getValue();
            if (preTo < from) {
                result.put(from, to);
                preFrom = from;
                preTo = to;
            } else {
                result.put(preFrom, Math.max(preTo, to));
                preTo = Math.max(preTo, to);
            }
        }
        int[][] arr = new int[result.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            arr[idx][0] = entry.getKey();
            arr[idx][1] = entry.getValue();
            idx++;
        }
        return arr;
    }
}
