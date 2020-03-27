package likou.first_try.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-03-27
 * https://leetcode-cn.com/problems/two-sum/
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{i, map.get(gap)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
