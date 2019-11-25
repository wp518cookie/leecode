package first.medium;

import java.util.*;

/**
 * Created by ping.wu on 2017/2/24.
 */
public class Random_Pick_Index_398 {
    Map<Integer, ArrayList<Integer>> map = new HashMap();
    Random random = new Random();
    public Random_Pick_Index_398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i], list);
            } else {
                ArrayList<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
    }

    public int pick(int target) {
        int idx = 0;
        List<Integer> list = map.get(target);
        if (list.size() > 1) {
            idx = random.nextInt(list.size() - 1);
        }
        return list.get(idx);
    }

    public static void main(String[] args) {
        int[] n = new int[] {1};
        Random_Pick_Index_398 random_pick_index_398 = new Random_Pick_Index_398(n);
        System.out.println(random_pick_index_398.pick(1));
    }
}
