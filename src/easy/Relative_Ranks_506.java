package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Relative_Ranks_506 {
    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
        }
        Set<Integer> keySet = treeMap.descendingKeySet();
        int j = 0;
        for (Integer i : keySet) {
            if (j == 0) {
                result[treeMap.get(i)] = "Gold Medal";
                j++;
                continue;
            } else if (j == 1) {
                result[treeMap.get(i)] = "Silver Medal";
                j++;
                continue;
            } else if (j == 2) {
                result[treeMap.get(i)] = "Bronze Medal";
                j++;
                continue;
            } else {
                result[treeMap.get(i)] = String.valueOf(j + 1);
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
}
