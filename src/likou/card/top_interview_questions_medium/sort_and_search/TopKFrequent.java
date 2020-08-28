package likou.card.top_interview_questions_medium.sort_and_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvzpxi/
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(arr, 6)));
    }

    /**
     * 执行用时：
     * 18 ms, 在所有 Java 提交中击败了53.53%的用户
     * 内存消耗：
     * 42.2 MB, 在所有 Java 提交中击败了84.07%的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> count = new HashMap();
        for (int t : nums) {
            if (count.containsKey(t)) {
                count.put(t, count.get(t) + 1);
            } else {
                count.put(t, 1);
            }
        }
        int[] dump = new int[k];
        int size = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getKey();
            int times = entry.getValue();
            if (size < k) {
                dump[size++] = val;
                siftUp(dump, size - 1, count);
            } else {
                if (count.get(dump[0]) >= times) {
                    continue;
                } else {
                    dump[0] = val;
                    siftDown(dump, 0, count);
                }
            }
        }
        return dump;
    }

    public void siftUp(int[] dump, int k, Map<Integer, Integer> count) {
        int t = dump[k];
        int times = count.get(t);
        while (k > 0) {
            int parentIdx = (k - 1) / 2;
            if (count.get(dump[parentIdx]) > times) {
                dump[k] = dump[parentIdx];
                k = parentIdx;
            } else {
                break;
            }
        }
        dump[k] = t;
    }

    public void siftDown(int[] dump, int k, Map<Integer, Integer> count) {
        int t = dump[k];
        int times = count.get(t);
        while ((k * 2 + 1) < dump.length) {
            int idx = k * 2 + 1;
            if (idx < dump.length - 1 && count.get(dump[idx]) > count.get(dump[idx + 1])) {
                idx++;
            }
            if (count.get(dump[idx]) >= times) {
                break;
            } else {
                dump[k] = dump[idx];
                k = idx;
            }
        }
        dump[k] = t;
    }
}
