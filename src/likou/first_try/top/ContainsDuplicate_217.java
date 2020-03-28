package likou.first_try.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-03-28
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 */

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer t = nums[i];
            if (map.containsKey(t)) {
                map.put(t, -1);
            } else {
                map.put(t, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) {
                return true;
            }
        }
        return false;
    }
}
