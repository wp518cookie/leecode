package medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2018/12/29
 */

public class Perfect_Squares_279 {
    static Set<Integer> set = new LinkedHashSet<>();
    static List<Integer> list = new ArrayList();
    public static void main(String[] args) {
        System.out.println(numTrees(13));
    }

    public static int numTrees(int n) {
        int c = 1;
        int t = 0;
        while ((t = c * c) <= n) {
            list.add(t);
            set.add(t);
            c++;
        }
        int count = 1;
        System.out.println(list);
        while (true) {
            if (numTrees(0, count, n)) {
                return count;
            }
            count++;
        }
    }

    public static boolean numTrees(int startIdx, int c, int n) {
        if (c == 1) {
            return set.contains(n);
        }
        for (int i = startIdx;i < list.size();i++) {
            int temp = list.get(i);
            if (temp * c > n) {
                return false;
            }
            if (numTrees(startIdx, c - 1, n - temp)) {
                return true;
            }
        }
        return false;
    }
}
