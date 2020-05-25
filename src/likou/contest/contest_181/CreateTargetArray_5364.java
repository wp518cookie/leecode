package likou.contest.contest_181;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-03-22
 */

public class CreateTargetArray_5364 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List[] arr = new List[index.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList();
        }
        for (int i = 0; i < index.length; i++) {
            arr[index[i]].add(nums[i]);
        }
        int[] target = new int[index.length];
        int idx = target.length - 1;
        for (int i = index.length - 1; i >= 0; i--) {
            List<Integer> list = arr[i];
            if (list.size() == 0) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                target[idx--] = list.get(j);
            }
        }
        return target;
    }
}
