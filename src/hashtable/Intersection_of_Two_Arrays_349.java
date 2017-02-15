package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Intersection_of_Two_Arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        for (int i : nums1) {
            map1.put(i, i);
        }
        for (int i : nums2) {
            map2.put(i, i);
        }
        List<Integer> list = new ArrayList<Integer>();
        if (map1.size() >= map2.size()) {
            for (int i : map2.keySet()) {
                if (map1.containsKey(i)) {
                    list.add(i);
                }
            }
        } else {
            for (int i : map1.keySet()) {
                if (map2.containsKey(i)) {
                    list.add(i);
                }
            }
        }
        if (list.size() < 1) {
            return null;
        } else {
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
