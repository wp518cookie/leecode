package easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Remove_Element_27 {
    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}
