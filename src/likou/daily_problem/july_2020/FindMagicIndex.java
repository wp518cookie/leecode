package likou.daily_problem.july_2020;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-07-31
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
    魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
    示例1:

    输入：nums = [0, 2, 3, 4, 5]
    输出：0
    说明: 0下标的元素为0
 *
 */

public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        for (int i = 0; i < length;) {
            int t = nums[i];
            if (i == t) {
                return i;
            } else if (i < t) {
                i = t;
            } else if (i > t) {
                i++;
            }
        }
        return -1;
    }
}
