package likou.first_try.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-03
 * https://leetcode-cn.com/problems/pascals-triangle/
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */


public class PascalsTriangle_118 {
    public static void main(String[] args) {
        new PascalsTriangle_118().generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        if (numRows == 0) {
            return list;
        }
        List<Integer> l1 = new ArrayList();
        l1.add(1);
        list.add(l1);
        if (numRows == 1) {
            return list;
        }
        l1 = new ArrayList();
        l1.add(1);
        l1.add(1);
        list.add(l1);
        if (numRows == 2) {
            return list;
        }
        for (int i = 3; i <= numRows; i++) {
            l1 = new ArrayList();
            l1.add(1);
            List<Integer> pre = list.get(i - 1 - 1);
            for (int j = 0; j < pre.size() - 1; j++) {
                l1.add(pre.get(j) + pre.get(j + 1));
            }
            l1.add(1);
            list.add(l1);
        }
        return list;
    }
}
