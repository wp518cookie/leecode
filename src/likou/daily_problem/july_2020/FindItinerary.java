package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-27select * from common_service_db.t_coupon_packet_item;
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 *
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */

public class FindItinerary {
    public static void main(String[] args) {
//        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> tickets = new ArrayList();
        List<String> l1 = new ArrayList();
        l1.add("JFK");
        l1.add("KUL");
        List<String> l2 = new ArrayList();
        l2.add("JFK");
        l2.add("NRT");
        List<String> l3 = new ArrayList();
        l3.add("NRT");
        l3.add("JFK");
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        System.out.println(Arrays.toString(new FindItinerary().findItinerary(tickets).toArray()));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return result;
        }
        Map<String, List<String>> mark = new HashMap();
        for (List<String> meta : tickets) {
            String from = meta.get(0);
            String to = meta.get(1);
            if (mark.containsKey(from)) {
                mark.get(from).add(to);
            } else {
                List<String> list = new ArrayList();
                list.add(to);
                mark.put(from, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : mark.entrySet()) {
            Collections.sort(entry.getValue());
        }
        String from = "JFK";
        result.add(from);
        while (mark.containsKey(from)) {
            List<String> toList = mark.get(from);
            String to = toList.remove(0);
            if (toList.size() == 0) {
                mark.remove(from);
            }
            result.add(to);
            from = to;
        }
        return new ArrayList<>(result);
     }
}
