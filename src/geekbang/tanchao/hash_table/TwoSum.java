package geekbang.tanchao.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2019-05-21
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{map.get(gap), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
