package likou.company.bytedance.sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-28
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1019/
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            } else {
                map.put(nums[i], i);
                nums[size++] = nums[i];
            }
        }
        int result = 1;

        for (int i = 0; i < size; i++) {
            if (map.get(nums[i]) < 0) {
                continue;
            } else {
                map.put(nums[i], -1);
                int t = nums[i] - 1;
                int count = 1;
                while (map.containsKey(t)) {
                    map.put(t, -1);
                    count++;
                    t--;
                }
                t = nums[i] + 1;
                while (map.containsKey(t)) {
                    map.put(t, -1);
                    count++;
                    t++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
