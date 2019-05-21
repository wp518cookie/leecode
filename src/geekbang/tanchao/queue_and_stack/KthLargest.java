package geekbang.tanchao.queue_and_stack;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-05-16
 */

public class KthLargest {
    private int[] arr;
    private int size = 0;

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(Arrays.toString(kthLargest.arr));
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }

    public KthLargest(int k, int[] nums) {
        arr = new int[k];
        if (nums.length > k) {
            for (int i = 0; i < k; i++) {
                arr[i] = nums[i];
                siftUp(i);
            }
            for (int i = k; i < nums.length; i++) {
                add(nums[i]);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
                siftUp(i);
            }
            for (int i = nums.length; i < arr.length; i++) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
    }

    public int add(int val) {
        if (arr.length == 0) {
            arr[0] = val;
        } else {
            int first = arr[0];
            if (arr[0] < val) {
                arr[0] = val;
                siftDown(0);
            }
        }
        return arr[0];
    }

    private void siftUp(int x) {
        int val = arr[x];
        while (x > 0) {
            int parent = (x - 1) >> 1;
            if (arr[parent] > val) {
                arr[x] = arr[parent];
                x = parent;
            } else {
                arr[x] = val;
                break;
            }
        }
    }

    private void siftDown(int x) {
        int val = arr[x];
        while (x < arr.length) {
            int left = (x << 1) + 1;
            if (left >= arr.length) {
                arr[x] = val;
                break;
            }
            int min = left;
            if (left + 1 < arr.length && arr[left] > arr[left + 1]) {
                min++;
            }
            if (arr[min] < val) {
                arr[x] = arr[min];
                x = min;
            } else {
                arr[x] = val;
                break;
            }
        }
    }
}
