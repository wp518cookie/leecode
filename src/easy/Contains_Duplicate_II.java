package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ping.wu on 2017/1/3.
 */
public class Contains_Duplicate_II {
    public static void main(String[] args) {
        int[] test = {1,2,1};
        System.out.println(containsNearbyDuplicate(test, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        if (nums.length <= k + 1) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return true;
                }
                map.put(nums[i], -1);
            }
            return false;
        } else {
            for (int i = 0; i <= k; i++) {
                if (map.containsKey(nums[i])) {
                    return true;
                }
                map.put(nums[i], -1);
            }
            for (int i = k + 1; i < nums.length; i++) {
                map.remove(nums[i - k - 1]);
                if (map.containsKey(nums[i])) {
                    return true;
                }
                map.put(nums[i], -1);
            }
            return false;
        }
    }
}
