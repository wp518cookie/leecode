package first.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class Intersection_of_Two_Arrays_II_350 {
    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                int temp = map1.get(nums1[i]);
                map1.put(nums1[i], temp + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                int temp = map2.get(nums2[i]);
                map2.put(nums2[i], temp + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        Map<Integer, Integer> big_map = map1.size() > map2.size() ? map1 : map2;
        Map<Integer, Integer> small_map = map1.size() <= map2.size() ? map1 : map2;
        for (Integer key : small_map.keySet()) {
            if (big_map.containsKey(key)) {
                int count = small_map.get(key) < big_map.get(key) ? small_map.get(key) : big_map.get(key);
                while (count-- > 0) {
                    result.add(key);
                }
            }
        }
        if (result.size() <= 0) {
            return new int[0];
        } else {
            int[] result_arr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                result_arr[i] = result.get(i);
            }
            return result_arr;
        }
    }
}
