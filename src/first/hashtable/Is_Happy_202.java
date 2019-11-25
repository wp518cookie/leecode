package first.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-26
 * https://leetcode.com/problems/happy-number/
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class Is_Happy_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        set.add(n);
        while (true) {
            int sum = 0;
            while (n > 0) {
                int t = n % 10;
                n = n / 10;
                sum += t * t;
            }
            n = sum;
            if (set.contains(sum)) {
                return sum == 1;
            } else {
                set.add(sum);
            }
        }
    }
}
