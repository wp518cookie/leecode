package geekbang.tanchao.queue_and_stack;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-05-21
 */

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int start = 0;
        int end = k - 1;
        while (true) {
            if (end >= nums.length) {
                break;
            }
            max = Integer.MIN_VALUE;
            maxIndex = -1;
            for (int i = start; i <= end; i++) {
                if (max <= nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            result[resultIdx++] = max;
            while (true) {
                if (start != maxIndex) {
                    start++;
                    end++;
                    if (end >= nums.length) {
                        return result;
                    } else {
                        if (nums[end] >= max) {
                            max = nums[end];
                            maxIndex = end;
                        }
                        result[resultIdx++] = max;
                    }
                } else {
                    start++;
                    end++;
                    break;
                }
            }
        }
        return result;
    }
}
