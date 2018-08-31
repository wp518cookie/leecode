package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2018/8/30
 * 杨辉三角
 */

public class Pascal_Triangle_118 {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> meta : result) {
            for(Integer i : meta) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> before = null;
        while (numRows > 0) {
            List<Integer> current = new LinkedList();
            if (before == null) {
                current.add(1);
                result.add(current);
                before = current;
            } else if (before.size() == 1) {
                before.add(1);
                result.add(before);
            } else {
                for (int i = 1; i < before.size(); i++) {
                    current.add(before.get(i - 1) + before.get(i));
                }
                ((LinkedList<Integer>) current).addFirst(1);
                ((LinkedList<Integer>) current).addLast(1);
                result.add(current);
                before = current;
            }
            numRows--;
        }
        return result;
    }
}
