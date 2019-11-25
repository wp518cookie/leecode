package first.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-23
 * https://leetcode.com/problems/positions-of-large-groups/
 */

public class Positions_of_Large_Groups_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList();
        if (S == null || S.length() < 3) {
            return result;
        }
        char pre = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != pre) {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList(2);
                    temp.add(i - count);
                    temp.add(i - 1);
                    result.add(temp);
                }
                count = 1;
                pre = S.charAt(i);
            } else {
                count++;
            }
        }
        if (count >= 3) {
            List<Integer> temp = new ArrayList();
            temp.add(S.length() - count);
            temp.add(S.length() - 1);
            result.add(temp);
        }
        return result;
    }
}
