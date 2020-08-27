package first.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-20
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 */

public class FindNumberOfLIS {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(arr));
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxMark = new int[nums.length];
        int[] countMark = new int[nums.length];
        maxMark[0] = 1;
        countMark[0] = 1;
        int count = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 1;
            int tempCount = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (tempMax < maxMark[j] + 1) {
                        tempMax = maxMark[j] + 1;
                        tempCount = countMark[j];
                    } else if (tempMax == maxMark[j] + 1) {
                        tempCount += countMark[j];
                    }
                }
            }
            maxMark[i] = tempMax;
            countMark[i] = tempCount;
            if (tempMax > max) {
                max = tempMax;
                count = tempCount;
            } else if (tempMax == max) {
                count += tempCount;
            }
        }
        return count;
    }
}
