package easy;

import java.util.*;

/**
 * Created by Administrator on 2017/12/8.
 */
public class Degree_of_an_Array_697 {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,3,2,2,3,1}));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> timeCount = new HashMap();
        Map<Integer, Integer> start = new HashMap();
        Map<Integer, Integer> end = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (timeCount.get(temp) == null) {
                start.put(temp, i);
                timeCount.put(temp, 1);
            } else {
                end.put(temp, i);
                timeCount.put(temp, timeCount.get(temp) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = timeCount.entrySet();
        int max = 0;
        Set<Integer> maxList = new HashSet();
        for (Map.Entry<Integer, Integer> t : set) {
            if (t.getValue() == max) {
                maxList.add(t.getKey());
            } else if (t.getValue() > max) {
                maxList = new HashSet();
                maxList.add(t.getKey());
                max = t.getValue();
            }
        }
        int result = -1;
        for (Integer k : maxList) {
            Integer startPoint = start.get(k);
            Integer endPoint = end.get(k);
            if (endPoint != null) {
                if (result == -1) {
                    result = endPoint - startPoint + 1;
                } else {
                    int newR = endPoint - startPoint + 1;
                    result = result < newR ? result : newR;
                }
            } else {
                result = 1;
            }
        }
        return result;
    }
}
