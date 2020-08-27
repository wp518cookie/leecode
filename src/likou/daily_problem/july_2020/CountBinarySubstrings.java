package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-10
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int result = 0;
        if (s == null || s.length() <= 1) {
            return result;
        }
        List<Integer> mark = new ArrayList();
        boolean zeroFlag = s.charAt(0) == '0';
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            boolean isZero = s.charAt(i) == '0';
            if (isZero) {
                if (zeroFlag) {
                    count++;
                } else {
                    mark.add(count);
                    zeroFlag = true;
                    count = 1;
                }
            } else {
                if (zeroFlag) {
                    mark.add(count);
                    zeroFlag = false;
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        if (count > 0) {
            mark.add(count);
        }
        for (int i = 1; i < mark.size(); i++) {
            result += Math.min(mark.get(i - 1), mark.get(i));
        }
        return result;
    }
}
