package likou.contest_183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-05
 */

public class MinSubsequence_5376 {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        int current = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            current += nums[i];
            result.add(nums[i]);
            if (current > count - current) {
                return result;
            }
        }
        return result;
    }
}
