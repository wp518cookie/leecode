package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-03
 * https://leetcode-cn.com/problems/majority-element/
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 */

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            } else {
                if (count > 1) {
                    count--;
                } else {
                    count = 1;
                    cur = nums[i];
                }
            }
        }
        return cur;
    }
}
