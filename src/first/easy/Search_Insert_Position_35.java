package first.easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Search_Insert_Position_35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        } else if (nums[0] > target) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        if (nums[mid] >= target) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
