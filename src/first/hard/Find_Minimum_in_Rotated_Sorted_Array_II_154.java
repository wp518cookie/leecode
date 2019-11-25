package first.hard;

/**
 * Created by Administrator on 2018/3/13.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,0,1,1,1}));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            int startVal = nums[start];
            int endVal = nums[end];
            int midVal = nums[mid];
            if (midVal < endVal) {
                end = mid;
            } else if (midVal > endVal) {
                start = mid;
            } else {
                int t = mid;
                while (t + 1 <= end && nums[t + 1] == midVal) {
                    t++;
                }
                if (t == end) {
                    end = mid;
                } else {
                    start = t;
                }
            }
        }
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
