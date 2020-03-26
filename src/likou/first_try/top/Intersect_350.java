package likou.first_try.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-03-26
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 *
 * todo
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */

public class Intersect_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        if (nums2.length > nums1.length) {
              int[] temp = nums1;
              nums1 = nums2;
              nums2 = temp;
        }
        // nums1是大的， nums2是结果集小的
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) + 1);
            } else {
                map.put(nums2[i], 1);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            int t = nums1[i];
            Integer count = map.get(t);
            if (count != null && count > 0) {
                result.add(t);
                map.put(t, count - 1);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
