package likou.card.top_interview_questions_medium.sort_and_search;

/**
 * @author wuping
 * @date 2020-08-28
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvsehe/
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] topK = new int[k];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (size < k) {
                topK[size++] = nums[i];
                siftUp(topK, size - 1);
            } else {
                if (topK[0] >= nums[i]) {
                    continue;
                } else {
                    topK[0] = nums[i];
                    siftDown(topK, 0);
                }
            }
        }
        return topK[0];
    }

    private void siftUp(int[] arr, int k) {
        int t = arr[k];
        while (k > 0) {
            int parentIdx = (k - 1) / 2;
            if (arr[parentIdx] > t) {
                arr[k] = arr[parentIdx];
                k = parentIdx;
            } else {
                break;
            }
        }
        arr[k] = t;
    }

    private void siftDown(int[] arr, int k) {
        int t = arr[k];
        while ((2 * k + 1) < arr.length) {
            int left = 2 * k + 1;
            if (left < arr.length - 1 && arr[left] > arr[left + 1]) {
                left++;
            }
            if (arr[left] < t) {
                arr[k] = arr[left];
                k = left;
            } else {
                break;
            }
        }
        arr[k] = t;
    }
}
