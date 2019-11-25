package first.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-09-18
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class Kth_Largest_Element_in_an_Array_215 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        Kth_Largest_Element_in_an_Array_215 t = new Kth_Largest_Element_in_an_Array_215();
        System.out.println(t.findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int pivot = findPivot(nums);
        List<Integer> before = new ArrayList();
        List<Integer> mid = new ArrayList();
        List<Integer> after = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                after.add(nums[i]);
            } else if (nums[i] < pivot) {
                before.add(nums[i]);
            } else {
                mid.add(nums[i]);
            }
        }
        if (after.size() >= k) {
            return findKthLargest(after, k);
        } else if (mid.size() + after.size() >= k) {
            return pivot;
        } else {
            return findKthLargest(before, k - mid.size() - after.size());
        }
    }

    public int findKthLargest(List<Integer> list, int k) {
        int pivot = findPivot(list);
        List<Integer> before = new ArrayList();
        List<Integer> mid = new ArrayList();
        List<Integer> after = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > pivot) {
                after.add(list.get(i));
            } else if (list.get(i) < pivot) {
                before.add(list.get(i));
            } else {
                mid.add(list.get(i));
            }
        }
        if (after.size() >= k) {
            return findKthLargest(after, k);
        } else if (mid.size() + after.size() >= k) {
            return pivot;
        } else {
            return findKthLargest(before, k - mid.size() - after.size());
        }
    }

    public int findPivot(int[] nums) {
        int start = nums[0];
        int end = nums[nums.length - 1];
        int mid = nums[(nums.length - 1) >> 1];
        if (start > mid && end > mid) {
            return start > end ? end : start;
        } else if (start < mid && end < mid) {
            return start > end ? start : end;
        } else {
            return mid;
        }
    }

    public int findPivot(List<Integer> nums) {
        int start = nums.get(0);
        int end = nums.get(nums.size() - 1);
        int mid = nums.get((nums.size() - 1) >> 1);
        if (start > mid && end > mid) {
            return start > end ? end : start;
        } else if (start < mid && end < mid) {
            return start > end ? start : end;
        } else {
            return mid;
        }
    }
}
