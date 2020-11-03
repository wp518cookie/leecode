package likou.daily_problem.july_2020.nov_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-11-02
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 */

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Set<Integer> mark = new HashSet(nums1.length);
        for (int t : nums1) {
            mark.add(t);
        }
        Set<Integer> result = new HashSet();
        for (int t : nums2) {
            if (mark.contains(t)) {
                result.add(t);
            }
        }
        if (result.size() == 0) {
            return new int[0];
        }
        List<Integer> resultList = new ArrayList(result);
        int[] array = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            array[i] = resultList.get(i);
        }
        return array;
    }
}
