package first.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class Contains_Duplicate_217 {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i],0);
        }
        return false;
    }
}
