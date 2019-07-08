package geekbang.tanchao.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-03
 */

public class Triangle {
    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> blow = triangle.get(i + 1);
            List<Integer> cur = triangle.get(i);
            int t1 = blow.get(0);
            int t2;
            for (int j = 0; j < cur.size(); j++) {
                t2 = blow.get(j + 1);
                int val = t1;
                if (t1 > t2) {
                    val = t2;
                }
                cur.set(j, cur.get(j) + val);
                t1 = t2;
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {
         List<Integer> pre = new ArrayList();
        pre.add(triangle.get(0).get(0));
         for (int i = 1; i < triangle.size(); i++) {
             List<Integer> current = triangle.get(i);
             List<Integer> meta = new ArrayList();
             meta.add(pre.get(0) + current.get(0));
             for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                 int t1 = pre.get(j - 1);
                 int t2 = pre.get(j);
                 int val = t1;
                 if (t1 > t2) {
                     val = t2;
                 }
                 meta.add(current.get(j) + val);
             }
             meta.add(pre.get(pre.size() - 1) + current.get(current.size() - 1));
             pre = meta;
         }
         int t = Integer.MAX_VALUE;
         for (int i = 0; i < pre.size(); i++) {
             if (t > pre.get(i)) {
                 t = pre.get(i);
             }
         }
         return t;
    }
}
