package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-19
 * https://leetcode.com/problems/fair-candy-swap/
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 */

public class Fair_Candy_Swap_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set2 = new HashSet();
        int sum = 0;
        for (int i = 0; i < B.length; i++) {
            sum = sum - B[i];
            set2.add(B[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (sum > 0) {
                int t = A[i] - sum / 2;
                if (set2.contains(t)) {
                    return new int[]{A[i], t};
                }
            } else {
                int t = (-sum) / 2 + A[i];
                if (set2.contains(t)) {
                    return new int[]{A[i], t};
                }
            }
        }
        return new int[0];
    }
}
