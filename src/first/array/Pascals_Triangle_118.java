package first.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-23
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class Pascals_Triangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> first = new ArrayList();
        first.add(1);
        result.add(first);
        if (numRows == 1) {
            return result;
        }
        List<Integer> second = new ArrayList();
        second.add(1);
        second.add(1);
        result.add(second);
        if (numRows == 2) {
            return result;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList();
            temp.add(1);
            List<Integer> preList = result.get(i - 2);
            for (int j = 0; j < preList.size() - 1; j++) {
                temp.add(preList.get(j) + preList.get(j + 1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
