package likou.contest.doubleweek.contest_27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-30
 * https://leetcode-cn.com/contest/biweekly-contest-27/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

public class HasAllCodes {
    public static void main(String[] args) {
        String s = "10010011";
        System.out.println(new HasAllCodes().hasAllCodes(s, 2));
    }
    public boolean hasAllCodes(String s, int k) {
        if (k >= s.length()) {
            return false;
        }
        Set<Integer> set = new HashSet();
        int t = Integer.valueOf(s.substring(0, k), 2);
        set.add(t);
        int mask = ~(1 << (k - 1));
        for (int i = k; i < s.length(); i++) {
            t = t & mask;
            t = (t << 1);
            if (s.charAt(i) == '1') {
                t++;
            }
            set.add(t);
        }
        return set.size() == (1 << k);
    }
}
