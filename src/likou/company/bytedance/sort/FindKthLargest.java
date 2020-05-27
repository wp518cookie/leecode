package likou.company.bytedance.sort;

/**
 * @author wuping
 * @date 2020-05-27
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1018/
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new FindKthLargest().findKthLargest(arr, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int[] dump = new int[k + 1];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (size < k) {
                dump[++size] = nums[i];
                siftUp(dump, size);
            } else {
                if (dump[1] < nums[i]) {
                    dump[1] = nums[i];
                    siftDown(dump, 1);
                }
            }
        }
        return dump[1];
    }

    private void siftUp(int[] arr, int idx) {
        int temp = arr[idx];
        while (idx > 1 && arr[idx / 2] > temp) {
            arr[idx] = arr[idx / 2];
            idx = idx / 2;
        }
        arr[idx] = temp;
    }

    private void siftDown(int[] arr, int idx) {
        int temp = arr[idx];
        while (idx * 2 < arr.length) {
            int left = idx * 2;
            if (left + 1 < arr.length && arr[left + 1] < arr[left]) {
                left++;
            }
            if (arr[left] < temp) {
                arr[idx] = arr[left];
                idx = left;
            } else {
                break;
            }
        }
        arr[idx] = temp;
    }
}
