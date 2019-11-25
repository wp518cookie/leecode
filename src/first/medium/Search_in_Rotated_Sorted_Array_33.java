package first.medium;

/**
 * Created by Administrator on 2018/3/12.
 */
public class Search_in_Rotated_Sorted_Array_33 {
    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{1, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int startVal = nums[start];
        int endVal = nums[end];
        int mid;
        int midVal;
        while (start < end) {
            mid = (start + end) / 2;
            midVal = nums[mid];
            if (midVal < endVal) {
                if (midVal < target) {
                    if (endVal >= target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else if (midVal > target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (startVal > target) {
                    start = mid + 1;
                } else if (startVal < target) {
                    if (midVal > target) {
                        end = mid - 1;
                    } else if (midVal < target) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                } else {
                    return start;
                }
            }
        }
        return nums[start] == target ? start : -1;
    }
}
