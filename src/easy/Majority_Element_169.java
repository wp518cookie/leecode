package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ping.wu on 2016/12/30.
 */
public class Majority_Element_169 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int size = nums.length;
        int flag = size / 2;
        int[] count = new int[nums.length];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = map.get(nums[i]);
            if (temp != null) {
                if (temp + 1 > flag) {
                    return nums[i];
                }
                map.put(nums[i], temp + 1);
            } else {
                if (flag < 1) {
                    return nums[i];
                }
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
