package first.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2016/12/28.
 */
public class Find_All_Numbers_448 {
    public static void main(String[] args) {
        int[] n = {4, 3, 2, 3, 1};
        System.out.println(findDisappearedNumbers(n));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            while (nums[temp] > 0) {
                int temp1 = nums[temp] - 1; //index值
                int temp2 = nums[temp1];
                nums[temp1] = -1;
                if (temp2 < 0) {
                    break;
                }
                temp = temp2 - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
