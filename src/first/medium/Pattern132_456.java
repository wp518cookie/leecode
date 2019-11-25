package first.medium;

import java.util.ArrayList;

/**
 * Created by ping.wu on 2016/12/1.
 */
public class Pattern132_456 {
    public static void main(String[] args) {
        int[] test = new int[]{1,3,2,4,1,3,2};
        System.out.println(find132pattern(test));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                list.add(nums[i]);
            }
        }
        if (list.size() < 3) {
            return false;
        }
        for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    if (list.get(i) < list.get(j)) {
                        for (int z = j + 1; z < list.size(); z++) {
                            if (list.get(z) < list.get(j) && list.get(z) > list.get(i)) {
                                return true;
                            }
                        }
                    }
            }
        }
        return false;
    }
}
