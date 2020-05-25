package likou.contest.contest_185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wuping
 * @date 2020-04-19
 */

public class DisplayTable_5389 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, Map<String, Integer>> tableFoodMap = new TreeMap();
        TreeSet<String> foodsSet = new TreeSet();
        for (int i = 0; i < orders.size(); i++) {
            List<String> orderList = orders.get(i);
            Integer tableId = Integer.valueOf(orderList.get(1));
            String foodName = orderList.get(2);
            if (tableFoodMap.containsKey(tableId)) {
                Map<String, Integer> foodMap = tableFoodMap.get(tableId);
                if (foodMap.containsKey(foodName)) {
                    foodMap.put(foodName, foodMap.get(foodName) + 1);
                } else {
                    foodMap.put(foodName, 1);
                }
            } else {
                Map<String, Integer> foodMap = new HashMap();
                tableFoodMap.put(tableId, foodMap);
                foodMap.put(foodName, 1);
            }

            if (!foodsSet.contains(foodName)) {
                foodsSet.add(foodName);
            }
        }

        List<List<String>> result = new ArrayList();
        List<String> title = new ArrayList();
        title.add("Table");
        for (String key : foodsSet) {
            title.add(key);
        }
        result.add(title);
        for (Map.Entry<Integer, Map<String, Integer>> entry : tableFoodMap.entrySet()) {
            List<String> meta = new ArrayList(title.size());
            String tableId = entry.getKey().toString();
            Map<String, Integer> foodMap = entry.getValue();
            meta.add(tableId);
            for (int i = 1; i < title.size(); i++) {
                if (foodMap.containsKey(title.get(i))) {
                    meta.add(foodMap.get(title.get(i)).toString());
                } else {
                    meta.add("0");
                }
            }
            result.add(meta);
        }
        return result;
    }
}
