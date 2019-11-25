package first.easy;

/**
 * @author wuping
 * @date 2019-11-06
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 */

public class Split_a_String_in_Balanced_Strings_1221 {

    public int balancedStringSplit(String s) {
        int lCount = 0;
        int rCount = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            } else if (s.charAt(i) == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
        }
        return result;
    }
}
